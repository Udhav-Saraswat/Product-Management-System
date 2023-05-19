package com.product.ProductManagement.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Products")
public class Products {
	
	private Integer productCombinationId; 
	
	@JsonProperty("products")
	private List<Product> productList;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Integer getProductCombinationId() {
		return productCombinationId;
	}

	public void setProductCombinationId(Integer productCombinationId) {
		this.productCombinationId = productCombinationId;
	}

	
}
