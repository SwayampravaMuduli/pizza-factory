package com.amazin.Dto;

import java.util.List;

public class PizzaDto {
	private int id;
	private String name;
	private String type;
	private String size;
	private String crust;
	private Float price;
	private String userType;

	private List<ToppingDto> toppings;
	private List<SideDto> sides;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public List<ToppingDto> getToppings() {
		return toppings;
	}
	public void setToppings(List<ToppingDto> toppings) {
		this.toppings = toppings;
	}
	public List<SideDto> getSides() {
		return sides;
	}
	public void setSides(List<SideDto> sides) {
		this.sides = sides;
	}
	@Override
	public String toString() {
		return "PizzaDto [id=" + id + ", name=" + name + ", type=" + type + ", size=" + size + ", crust=" + crust
				+ ", price=" + price + ", userType=" + userType + ", toppings=" + toppings + ", sides=" + sides + "]";
	}
	

	
	

}
