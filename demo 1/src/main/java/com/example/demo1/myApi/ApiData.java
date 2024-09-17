package com.example.demo1.myApi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


 class ApiData {
	private String id;
	private String name;
	private String role;
	public ApiData(String id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


}
