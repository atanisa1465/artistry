package com.example.Admin;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class User {
	@BsonProperty(value = "_id")
	private String email;
	@BsonProperty(value = "Username")
	private String username;
	@BsonProperty(value = "Password")
	private String password;
	
	public User() {
		super();
	}
	
	public User(String e, String age, String pass) {
		super();
		this.email = e;
		this.username = age;
		this.password = pass;
	}

    public User(String age, String pass) {
		super();
		this.username = age;
		this.password = pass;
	}
	
	public String getEmail() {
		return email;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getUsername() {
		return username;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	public String getPass() {
		return password;
	}

}