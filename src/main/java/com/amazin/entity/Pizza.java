package com.amazin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "size")
	private String size;

	@Column(name = "crust")
	private String crust;

	@Column(name = "price")
	private Float price;
	

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Pizza(int id, String name, String type, String size, String crust, Float price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.size = size;
		this.crust = crust;
		this.price = price;
	}

	public Pizza() {
		super();

	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", name=" + name + ", type=" + type + ", size=" + size + ", crust=" + crust
				+ ", price=" + price + "]";
	}
	

}
