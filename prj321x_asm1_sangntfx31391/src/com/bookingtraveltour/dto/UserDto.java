package com.bookingtraveltour.dto;

public class UserDto {
	private int id;
	private int role_id;
	private String role_name;
	private String fullname;
	private String password;
	private String username;
	private String email;

	private String phoneNumber;
	private String address;
	private boolean status;

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

//	public UserDto(int id, int role_id, String role_name, String fullname, String password, String username,
//			String email, String address, String phoneNumber, boolean status) {
//		super();
//		this.id = id;
//		this.role_id = role_id;
//		this.role_name = role_name;
//		this.fullname = fullname;
//		this.password = password;
//		this.username = username;
//		this.email = email;
//		this.address = address;
//		this.phoneNumber = phoneNumber;
//		this.status = status;
//	}
	public UserDto(int id, int role_id, String role_name, String fullname, String password, String username,
			String email, String phoneNumber, String address, boolean status) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.role_name = role_name;
		this.fullname = fullname;
		this.password = password;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
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

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
