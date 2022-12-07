package com.java.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRestaurant
 */
@WebServlet("/AddRestaurant")
public class AddRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRestaurant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RestaurantBeanRemote service=null;
		PrintWriter out=response.getWriter();
		
		String rest_name=request.getParameter("rest_name");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		String rest_email=request.getParameter("rest_email");
		String rest_userName=request.getParameter("rest_userName");
		String rest_password=request.getParameter("rest_password");

		Restaurant restaurant=new Restaurant();
		restaurant.setRest_name(rest_name);
		restaurant.setCity(city);
		restaurant.setState(state);
		restaurant.setPincode(pincode);
		restaurant.setRest_email(rest_email);
		restaurant.setRest_userName(rest_userName);
		restaurant.setRest_password(rest_password);
		try {
			service=(RestaurantBeanRemote) new InitialContext().lookup("RestaurantBean/remote");
			out.println(service.addRestaurantBean(restaurant));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
