package com.product.ProductManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.product.ProductManagement.entity.Product;

@Configuration
public class ProductConfig {
	
	@Bean
	Product productBean(){
		return new Product();
	}
	
}
