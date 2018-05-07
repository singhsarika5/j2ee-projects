package com.myprojects.beans;

public class Librarian {

	private int id;
	private String name, email, password;
	private long mobile;

	public Librarian() {
	}

	public Librarian(int id, String name, String email, String password, long mobile) {
	 	this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public int getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public long  getMobile() {
		return this.mobile;
	}
	

}
