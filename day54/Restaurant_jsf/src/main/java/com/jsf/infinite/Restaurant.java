package com.jsf.infinite;

import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@ManagedBean
@Entity
@Table(name = "restaurant")
public class Restaurant {

	
	
	
	@Id
	@Column(name = "rest_id")
	private String rest_id;
	@Column(name = "rest_name")
	private String rest_name;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private int pincode;
	@Column(name = "rest_email")
	private String rest_email;
	@Column(name = "rest_mob_no")
	private String rest_mob_no;
	@Column(name = "rest_userName")
	private String rest_userName;
	@Column(name = "rest_password")
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

	
}