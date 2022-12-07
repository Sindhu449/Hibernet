package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RestaurantBeanRemote {

	List<Restaurant> showRestaurantBean() throws ClassNotFoundException, SQLException;
	String addRestaurantBean(Restaurant restaurant) throws ClassNotFoundException, SQLException;
}
