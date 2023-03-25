package com.amazin.Dto;

public class ToppingDto {
	private int id;
	private String type;
	private String name;
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
	@Override
	public String toString() {
		return "ToppingDto [id=" + id + ", type=" + type + ", name=" + name + ", price=" + price + "]";
	}
	

	

}
