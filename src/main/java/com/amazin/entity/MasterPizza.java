package com.amazin.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "master_pizza")
public class MasterPizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "name_pizza", referencedColumnName = "name", nullable = true, insertable = false, updatable = false)
	private List<SizePrice> sizeAndPrice;

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

	public List<SizePrice> getSizeAndPrice() {
		return sizeAndPrice;
	}

	public void setSizeAndPrice(List<SizePrice> sizeAndPrice) {
		this.sizeAndPrice = sizeAndPrice;
	}

	@Override
	public String toString() {
		return "MasterPizza [id=" + id + ", name=" + name + ", sizeAndPrice=" + sizeAndPrice + "]";
	}
	

}
