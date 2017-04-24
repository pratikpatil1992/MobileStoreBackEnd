package com.niit.MobileStoreBackEnd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class User 
{
	
	//define which is the primary key
	@Id
	@Column
	private String id;
	
	@Column(name="name")  //if the field name in table and property name in class is different, column name needs to be specified
	
	private String name;
	@Column
	private String role;
	
	@Min(5)
	@Max(15)
	@Column
	private String password;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
