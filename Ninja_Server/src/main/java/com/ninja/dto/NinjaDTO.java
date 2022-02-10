package com.ninja.dto;

public class NinjaDTO {
	
	private Integer Id;
	private String name;
	private String designation;
	
	public Integer getId() {
	return Id;
	}
	
	public void setId(Integer Id) {
	this.Id = Id;
	}
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
	this.name = name;
	}
	
	public String getDesignation() {
	return designation;
	}
	
	public void setDesignation(String designation) {
	this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "Ninja [ninjaId=" + Id + ", name=" + name + ", designation=" + designation + "]";
	}
}
