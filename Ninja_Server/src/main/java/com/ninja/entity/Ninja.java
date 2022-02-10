package com.ninja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Id;
@JsonPropertyOrder({"Id", "name", "designation"})
@Entity
@Table(name="NINJA")
public class Ninja {
	@Id
	@Column(name="NINJA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	public Ninja() {
	}
	
	public Ninja( String name, String des ) {
		this.Id = 9998;
		this.name = name;
		this.designation = des;
	}

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ninja other = (Ninja) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} 
		else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
}
