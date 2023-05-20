package com.product.ProductManagement.intrface.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.product.ProductManagement.dto.DeleteRequest;
import com.product.ProductManagement.dto.PatchRequest;
import com.product.ProductManagement.dto.ProductDTO;
import com.product.ProductManagement.entity.Products;

public interface ProductServiceInterface {
	
	
	ProductDTO addProduct(Products products);
	
	
	List<Products> getProduct();
	
	
	ProductDTO updateproduct(Products products);
	
	
	HttpStatus patchProduct(PatchRequest patchRequest);
	
	
	HttpStatus deleteProduct(DeleteRequest deleteRequest);

}
