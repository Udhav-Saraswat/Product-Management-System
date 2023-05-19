package com.product.ProductManagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.ProductManagement.dto.PatchRequest;
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
	
	
	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody Products products){
		
		String result = "";
		HttpStatus httpStatus = HttpStatus.CREATED;
		
		List<Products> productList = productRepository.findAll();
		
		List<Integer> ids = new ArrayList<>();
				
		productList.forEach(product ->
		    ids.add(product.getId())
		);
		
       try {
    	   
    	   if(ids.contains(products.getId())) {
    		   productRepository.save(products);
   			   result = "Updated";
    	   } else {
    		   result = "Data not fount";
    	   }
			
			
		} catch (Exception e) {
			result = "Failed";
			httpStatus = HttpStatus.BAD_REQUEST;
		}
       
       
       return new ResponseEntity<String>(result,httpStatus);
	}
	
	
	// for the given id update title for all the products
	// in PUT API we update the whole object in database
	// while in patch API our aim is to update only some of the attributes
	
	@PatchMapping("/patchProduct")
	public ResponseEntity<Void> patchProduct(@RequestBody PatchRequest patchRequest){
		
		List<Products> productList =  productRepository.findAll();
		HttpStatus httpStatus = HttpStatus.CREATED;
		
		productList.forEach(product -> {
			if(product.getId() == patchRequest.getId()) {
				product.getProductList().forEach(productElement -> {
					productElement.setTitle(patchRequest.getTitle());
					productRepository.save(product);
				});
			}
		});
		
		return new ResponseEntity<>(httpStatus);
	
	
	}
	

}
