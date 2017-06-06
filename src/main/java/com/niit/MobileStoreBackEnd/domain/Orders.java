package com.niit.MobileStoreBackEnd.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class Orders
{
	@Id
	private int id;
	
	@Column
	private double quantity;
	
	@Column
	private String product_Id;

	@Column
	private String username;
	
	@Column
	private String product_Name;
	
	@Column
	private double price;
	
	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
