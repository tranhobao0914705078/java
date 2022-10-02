package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	Integer id, quantity, categoryId;
	String name, image;
	Double unitPrice;

	public Product() {
		super();
	}

	public Product(Integer id, Integer quantity, Integer categoryId, String name, String image, Double unitPrice) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.categoryId = categoryId;
		this.name = name;
		this.image = image;
		this.unitPrice = unitPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
}
