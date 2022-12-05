package com.jsf.infinite;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name="RestaurantDAO")
@SessionScoped
public class RestaurantDAO {

	SessionFactory sessionFactory;

	public String addRestaurant(Restaurant restaurant) throws Exception   {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Restaurant.class);
		Transaction transaction = session.beginTransaction();
		String restId = idgenerate();
		restaurant.setRest_id(restId);
		session.save(restaurant);
		transaction.commit();
		session.close();
		return "restaurant added";
	}
	public String checkUsers(Restaurant restaurant) {
        sessionFactory = SessionHelper.getConnection();
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Restaurant.class);
        cr.add(Restrictions.eq("rest_userName", restaurant.getRest_userName() ));
        cr.add(Restrictions.eq("rest_password", restaurant.getRest_password()));
        System.out.println(restaurant.getRest_password());
        System.out.println(restaurant.getRest_userName());
        List<Restaurant> listrestaurant = cr.list();
        if(listrestaurant.size()==1) {
            return "ShowRestaurant.xhtml?faces-redirect=true";
        }else {
            return "RestaurantLogin.xhtml?faces-redirect=true";
        }
        }
	
	public String idgenerate() {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Restaurant.class);
		List<Restaurant> resturantList = cr.list();
		if (resturantList.size() == 0) {
			return "R001";

		} else {
			String id = resturantList.get(resturantList.size() - 1).getRest_id();
			int id1 = Integer.parseInt(id.substring(1));
			id1++;
			String id2 = String.format("R%03d", id1);
			return id2;
		}
	}
	public void validatePhnNo(FacesContext context, UIComponent comp,
			Object value) {

		System.out.println("inside validate method");

		String mno = (String) value;
		boolean flag=false;
		if (mno.matches("\\d{10}"))  
		{ flag=true;}
		
	      if(flag==false) {
	    	  ((UIInput) comp).setValid(false);

				FacesMessage message = new FacesMessage(
						"invalid PhnNo");
				context.addMessage(comp.getClientId(context), message); 
	      }
	}
	
	public void validatePassword(FacesContext context, UIComponent comp,
			Object value) {

		System.out.println("inside validate method");

		String mno = (String) value;
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	      boolean result=mno.matches(pattern);
	      if(result==false) {
	    	  ((UIInput) comp).setValid(false);

				FacesMessage message = new FacesMessage(
						"invalid Password");
				context.addMessage(comp.getClientId(context), message); 
	      }
		
	

	}
	public void validateEmail(FacesContext context, UIComponent comp,
			Object value) {

		System.out.println("inside validate method");

		String mno = (String) value;
		if (mno.indexOf('@')==-1) {
			((UIInput) comp).setValid(false);

			FacesMessage message = new FacesMessage(
					"invalid Email");
			context.addMessage(comp.getClientId(context), message);
		}
		if (mno.length() < 6) {
			((UIInput) comp).setValid(false);

			FacesMessage message = new FacesMessage(
					"Minimum length of model number is 6");
			context.addMessage(comp.getClientId(context), message);

		}

	}
	public List<Restaurant> searchRestaurant(String userName) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Restaurant.class);
		criteria.add(Restrictions.eq("username", userName));
		List<Restaurant> resturantList = criteria.list();
		return resturantList;
	}

	public List<Restaurant> showRest() {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Restaurant.class);

		List<Restaurant> restList = criteria.list();
		return restList;
	}

	public int validate(String userName, String password) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Restaurant.class);
		cr.add(Restrictions.eq("username", userName));
		cr.add(Restrictions.eq("password", password));
		List<Restaurant> listres = cr.list();
		return listres.size();
	}

	public List<Restaurant> searchById(String restId) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Restaurant.class);
		criteria.add(Restrictions.eq("resturantId", restId));
		List<Restaurant> resturantList = criteria.list();
		return resturantList;
	}

	public List<OrderDetails> searchRestaurantId(String restId) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from OrderDetails where restId=:restId  " + "AND address is NOT NULL")
				.setParameter("restId", restId);
		List<OrderDetails> orderList = query.list();
		return orderList;
	}

	public List<OrderDetails> searchRestaurantOrder(String restId, String searchType) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(OrderDetails.class);
		Criterion criterion1, criterion2;
		if (searchType.equals("PENDING")) {

			Query query=session.createQuery("from OrderDetails where restId=:restId AND status=:status"
			+ " AND address is NOT NULL").setParameter("restId", restId).setParameter("status", Status.PENDING);
			
			List<OrderDetails> list = query.list();
			return list;	
			
		}
		else {
		if (searchType.equals("ACCEPTED")) {
			criterion1 = Restrictions.eq("restId", restId);
			criterion2 = Restrictions.eq("status", Status.ACCEPTED);
			cr.add(Restrictions.and(criterion1, criterion2));
		}

		if (searchType.equals("CANCELLED")) {
			criterion1 = Restrictions.eq("restId", restId);
			criterion2 = Restrictions.eq("status", Status.CANCELLED);
			cr.add(Restrictions.and(criterion1, criterion2));
		}

		if (searchType.equals("DELIVERED")) {
			criterion1 = Restrictions.eq("restId", restId);
			criterion2 = Restrictions.eq("status", Status.DELIVERED);
			cr.add(Restrictions.and(criterion1, criterion2));
		}

		if (searchType.equals("REJECTED")) {
			criterion1 = Restrictions.eq("restId", restId);
			criterion2 = Restrictions.eq("status", Status.REJECTED);
			cr.add(Restrictions.and(criterion1, criterion2));
		}

		List<OrderDetails> list = cr.list();
		return list;
	}
	}
}