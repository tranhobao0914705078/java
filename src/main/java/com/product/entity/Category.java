package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {
	Integer id;
	String name, namevn;

	public Category() {
		super();
	}

	public Category(Integer id, String name, String namevn) {
		super();
		this.id = id;
		this.name = name;
		this.namevn = namevn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamevn() {
		return namevn;
	}

	public void setNamevn(String namevn) {
		this.namevn = namevn;
	}
}
