package com.bus.reservation.models;

public class UserDetails {
	private String name;
	private String type;
	private String mobile;
	private String email;
	
	
	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", type=" + type + ", mobile=" + mobile + ", email=" + email + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
