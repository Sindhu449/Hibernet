package com.java.ejb;

import java.io.Serializable;

public class Restaurant implements Serializable{

	private String rest_id;
	private String rest_name;
	private String city;
	private String state;
	private int pincode;
	private String rest_email;
	private String rest_mob_no;
	private String rest_userName;
	private String rest_password;
	public String getRest_id() {
		return rest_id;
	}
	public void setRest_id(String rest_id) {
		this.rest_id = rest_id;
	}
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getRest_email() {
		return rest_email;
	}
	public void setRest_email(String rest_email) {
		this.rest_email = rest_email;
	}
	public String getRest_mob_no() {
		return rest_mob_no;
	}
	public void setRest_mob_no(String rest_mob_no) {
		this.rest_mob_no = rest_mob_no;
	}
	public String getRest_userName() {
		return rest_userName;
	}
	public void setRest_userName(String rest_userName) {
		this.rest_userName = rest_userName;
	}
	public String getRest_password() {
		return rest_password;
	}
	public void setRest_password(String rest_password) {
		this.rest_password = rest_password;
	}
	@Override
	public String toString() {
		return "Restaurant [rest_id=" + rest_id + ", rest_name=" + rest_name + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", rest_email=" + rest_email + ", rest_mob_no=" + rest_mob_no
				+ ", rest_userName=" + rest_userName + ", rest_password=" + rest_password + "]";
	}
	public Restaurant(String rest_id, String rest_name, String city, String state, int pincode, String rest_email,
			String rest_mob_no, String rest_userName, String rest_password) {
		
		this.rest_id = rest_id;
		this.rest_name = rest_name;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.rest_email = rest_email;
		this.rest_mob_no = rest_mob_no;
		this.rest_userName = rest_userName;
		this.rest_password = rest_password;
	}
	public Restaurant() {
	
		// TODO Auto-generated constructor stub
	}
	
	
	
}
