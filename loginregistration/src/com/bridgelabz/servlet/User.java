package com.bridgelabz.servlet;

public class User {
	String name;
	String email;
	long pnum;
	String password;
	String confrmpaswrd;
	
	
	
	public User(String name, String email, long pnum, String password, String confrmpaswrd) {
		super();
		this.name = name;
		this.email = email;
		this.pnum = pnum;
		this.password = password;
		this.confrmpaswrd = confrmpaswrd;
	}
	public String getConfrmpaswrd() {
		return confrmpaswrd;
	}
	public void setConfrmpaswrd(String confrmpaswrd) {
		this.confrmpaswrd = confrmpaswrd;
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
	public long getPnum() {
		return pnum;
	}
	public void setPnum(long pnum) {
		this.pnum = pnum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 
	

}