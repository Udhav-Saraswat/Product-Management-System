package com.product.ProductManagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.ProductManagement.entity.Products;
import com.product.ProductManagement.entity.UpdateRequest;
import com.product.ProductManagement.repository.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductAPI {
	
	
	@Autowired
	ProductRepository productRepository;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Products products){
		
		String result = "";
		HttpStatus httpStatus = HttpStatus.CREATED;
		
		products.getProductList().forEach(product -> {
			product.setCreatedDate(LocalDate.now());
		});
		
		try {
			
			productRepository.save(products);
			result = "SAVED";
			
		} catch (Exception e) {
			result = "Failed";
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<String>(result,httpStatus);
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<Products>> getAllProducts(){
		
		List<Products> productList = productRepository.findAll();
		
		return new ResponseEntity<>(productList,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/updateProducts")
	public ResponseEntity<String> updateProducts(@RequestBody UpdateRequest updateRequest){
		
		List<Products> productList = productRepository.findAll();
		List<String> result = new ArrayList<>();
		
		productList.forEach(productData -> {
			if(productData.getProductCombinationId() == updateRequest.getProductCombinationId()) {
				productData.getProductList().forEach(product -> {
					if(product.getProductId() == updateRequest.getProductId()) {
						product = updateRequest.getProduct();
						result.add("Updated");
					}
				});
			}
			
		});
		
		productRepository.save(productList.get(0));
		
		if(result == null) {
			return new ResponseEntity<>("Nothing is there to update", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Updated " + result.size() + " records", HttpStatus.ACCEPTED);
		}
		
	}
	

}
