package com.product.ProductManagement.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class UpdateRequest {
	
	private Integer productCombinationId;
	private Integer productId;
	private Product product;
	public Integer getProductCombinationId() {
		return productCombinationId;
	}
	public void setProductCombinationId(Integer productCombinationId) {
		this.productCombinationId = productCombinationId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
