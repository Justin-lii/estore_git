package com.briup.bean;

public class Customer {
	private Integer id;
	private String username;
	private String password;
	private String zip;
	private String phone;
	private String email;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String username, String password, String zip, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", zip=" + zip + ", phone="
				+ phone + ", email=" + email + "]";
	}
	
	
	
}
