package com.product.ProductManagement.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonPropertyOrder({"productId", "SKU", "title", "description", "price", "discountPercentage", "stock" 
	,"brand", "category", "badges", "avgRating", "rating", "inventoryCount", "createdDate" })
@JsonSerialize
public class Product {
	
	/*
	 {
			"productId": 1,
			"SKU": "HEH-2245",
			"title": "iPhone 9",
			"description": "An apple mobile which is nothing like apple",
			"price": 549,
			"discountPercentage": 12.96,
			"stock": 94,
			"brand": "Apple",
			"category": "smartphones",
			"badges": "Exclusive|Clearance",
			"avgRating": 4.5,
			"rating": 10,
			"inventoryCount": 8,
			"createdDate": "2018-03-20 22:24:21"
		}
	 */
	
	private Integer productId;
	private String SKU;
	private String title;
	private String description;
	private double price;
	private double discountPercentage;
	private Integer stock;
	private String brand;
	private String category;
	private String badges;
	private double AvgRating;
	private Integer rating;
	private Integer inventoryCount;
	private LocalDate createdDate;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBadges() {
		return badges;
	}
	public void setBadges(String badges) {
		this.badges = badges;
	}
	public double getAvgRating() {
		return AvgRating;
	}
	public void setAvgRating(double avgRating) {
		AvgRating = avgRating;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getInventoryCount() {
		return inventoryCount;
	}
	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
