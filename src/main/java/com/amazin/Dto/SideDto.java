package com.amazin.Dto;

public class SideDto {
	private int id;
    private String name;
    private Float price;
    private int count;
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "SideDto [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + "]";
	}
    
    
}