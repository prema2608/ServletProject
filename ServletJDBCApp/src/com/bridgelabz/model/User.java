package com.bridgelabz.model;

public class User {
	String name;
	String email;
	long pnumb;
	String passwrd;
	
	public User(String name, String email, long pnum, String password) {
		super();
		this.name = name;
		this.email = email;
		this.pnumb = pnum;
		this.passwrd = password;
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPnumb() {
		return pnumb;
	}
	public void setPnumb(long pnum) {
		this.pnumb = pnum;
	}
	public String getPassword() {
		return passwrd;
	}
	public void setPassword(String password) {
		this.passwrd = password;
	}
 
	

}