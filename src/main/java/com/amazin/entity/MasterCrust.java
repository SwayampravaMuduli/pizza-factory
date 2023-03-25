package com.amazin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "master_crust")
public class MasterCrust {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String crust;
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	@Override
	public String toString() {
		return "MasterCrust [id=" + id + ", crust=" + crust + "]";
	}
	

}
