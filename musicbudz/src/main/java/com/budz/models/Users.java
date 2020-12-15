package com.budz.models;

public class Users {

	private int userId;
	private String email;
	private String password;
	private String userName;
	private String firstName;
	private String lastName;
	
	
	public int getUserId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Users(int userId, String email, String password, String userName, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Users(String email, String password, String userName, String firstName, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
