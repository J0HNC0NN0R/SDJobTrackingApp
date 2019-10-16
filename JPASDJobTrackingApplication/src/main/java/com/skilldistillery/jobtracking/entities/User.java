package com.skilldistillery.jobtracking.entities;

public class User {
	private int id;
	private String username;
	//finish user entity when table is defined.
	
	// C O N S T R U C T O R S

	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
