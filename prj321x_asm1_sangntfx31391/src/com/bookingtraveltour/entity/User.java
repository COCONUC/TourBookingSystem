package com.bookingtraveltour.entity;

public class User {

	private int id;
	private int role_id;
	private String fullname;
	private String password;
	private String username;
	private String email;
	private String phoneNumber;
	private String address;
	private boolean status;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public User(int role_id, String fullname, String password, String username, String email, String phoneNumber,
			String address, boolean status) {
		super();
		this.role_id = role_id;
		this.fullname = fullname;
		this.password = password;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.status = status;
	}



	public User(int id, int role_id, String fullname, String password, String username, String email,
			String phoneNumber, boolean status) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.fullname = fullname;
		this.password = password;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
