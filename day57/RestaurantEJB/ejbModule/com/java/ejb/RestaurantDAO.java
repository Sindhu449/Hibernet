package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

	Connection connection;
	PreparedStatement pst;
	
	public List<Restaurant> showRestaurant() throws 
	ClassNotFoundException, SQLException {
      List<Restaurant> RestList = new ArrayList<Restaurant>();
      connection = ConnectionHelper.getConnection();
      String cmd = "select * from restaurant";
      pst = connection.prepareStatement(cmd);
      ResultSet rs = pst.executeQuery();
      Restaurant rest = null;
          while(rs.next()) {
        	  rest = new Restaurant();
        	  rest.setRest_id(rs.getString("rest_id"));
        	  rest.setRest_name(rs.getString("rest_name"));
        	  rest.setCity(rs.getString("city"));
        	  rest.setState(rs.getString("state"));
        	  rest.setPincode(rs.getString("pincode"));
        	  rest.setRest_email(rs.getString("rest_email"));
        	  rest.setRest_userName(rs.getString("rest_userName"));
        	  rest.setRest_password(rs.getString("rest_password"));
              RestList.add(rest);
      }
      return RestList;
  }
	public String generateRestId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(rest_id) is NULL THEN 'R001' else max(rest_id) end  rid from restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		String bid = rs.getString("rid");
		int id = Integer.parseInt(bid.substring(1));
		id++;
		String rid="";
		if (id >=1 && id <=9) {
			rid="R00"+id;
		}
		if (id >=10 && id <= 99) {
			rid="R0"+id;
		}
		if (id >=100 && id<=999) {
			rid="R"+id;
		}
		return rid;
	}
	public String addRestaurantBean(Restaurant restaurant) 
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String s=generateRestId();
		String cmd = "insert into restaurant(rest_id,rest_name,city,state,pincode,email,rest_userName,rest_password)"
				+ " values(?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, restaurant.getRest_name());
		pst.setString(2, restaurant.getCity());
		pst.setString(3, restaurant.getState());
		pst.setString(4, restaurant.getCity());
		pst.setString(5, restaurant.getPincode());
		pst.setString(6, restaurant.getRest_email());
		pst.setString(7, restaurant.getRest_userName());
		pst.setString(8, restaurant.getRest_password());
		pst.executeUpdate();
		return "Record Inserted...";
	}

}
