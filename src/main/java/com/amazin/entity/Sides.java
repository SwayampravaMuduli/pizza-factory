package com.amazin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sides")
public class Sides {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "price")
	private Float price;
	@Column(name = "name")
	private String name;
	@Column(name = "count")
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Sides(int id, Float price, String name, int count) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Sides [id=" + id + ", price=" + price + ", name=" + name + ", count=" + count + "]";
	}

}
