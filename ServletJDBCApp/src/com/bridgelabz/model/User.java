package com.bridgelabz.model;

public class User {
	int id;
	String name;
	String email;
	long pnumb;
	String passwrd;
	
	
	public User(int id, String name, String email, long pnumb, String passwrd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pnumb = pnumb;
		this.passwrd = passwrd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pnumb=" + pnumb + ", passwrd=" + passwrd
				+ "]";
	}

	
	

}