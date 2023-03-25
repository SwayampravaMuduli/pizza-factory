package com.amazin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "size_price_pizza")
public class SizePrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "size")
	private String size;
	@Column(name = "price")
	private Float price;
	@Column(name = "name_pizza")
	private String name;

	public SizePrice() {
		super();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public SizePrice(int id, String size, String name, Float price) {
		super();
		this.id = id;
		this.size = size;
		this.price = price;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
