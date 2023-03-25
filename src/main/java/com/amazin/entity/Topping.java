package com.amazin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "toppings")
public class Topping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "type")
	private String type;
	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Float price;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Topping(int id, String type, String name, Float price) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
	}

	public Topping() {
		super();
		
	}

	@Override
	public String toString() {
		return "Topping [id=" + id + ", type=" + type + ", name=" + name + ", price=" + price + "]";
	}
	



	

}
