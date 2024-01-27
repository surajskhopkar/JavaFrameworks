package com.pojo;

public class LoginRequestPOJO {
	
	private String username;
	private String password;
	
	public LoginRequestPOJO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestPOJO [username=" + username + ", password=" + password + "]";
	}
}
