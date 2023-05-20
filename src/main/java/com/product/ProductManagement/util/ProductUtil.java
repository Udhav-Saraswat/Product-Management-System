package com.product.ProductManagement.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.product.ProductManagement.entity.Products;

@Component
public class ProductUtil {

	
	public void addCreatedDate(Products products) {
		products.getProductList().forEach(product -> {
			product.setCreatedDate(LocalDate.now());
		});	
	}
	
	
	
}
