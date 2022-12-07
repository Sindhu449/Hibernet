package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class RestaurantBean
 */
@Stateless
@Remote(RestaurantBeanRemote.class)
public class RestaurantBean implements RestaurantBeanRemote {
    static RestaurantDAO rdao;
    static {
    	rdao = new RestaurantDAO();
    }
    /**
     * Default constructor. 
     */
    public RestaurantBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Restaurant> showRestaurantBean() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rdao.showRestaurant();
	}

	@Override
	public String addRestaurantBean(Restaurant restaurant) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return rdao.addRestaurantBean(restaurant);
	}

}
