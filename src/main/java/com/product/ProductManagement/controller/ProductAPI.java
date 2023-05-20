package com.product.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.ProductManagement.dto.ProductDTO;
import com.product.ProductManagement.dto.DeleteRequest;
import com.product.ProductManagement.dto.PatchRequest;
import com.product.ProductManagement.entity.Products;
import com.product.ProductManagement.intrface.service.ProductServiceInterface;

@RestController
@RequestMapping("product")
public class ProductAPI {
	
	@Autowired
	ProductServiceInterface productService;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Products products){
		
		ProductDTO addProduct = productService.addProduct(products);
		
		return new ResponseEntity<String>(addProduct.getResult(),addProduct.getHttpStatus());
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<Products>> getAllProducts(){
	
		return new ResponseEntity<>(productService.getProduct(),HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody Products products){
		
	   ProductDTO updateProduct = productService.updateproduct(products);
       return new ResponseEntity<String>(updateProduct.getResult(),updateProduct.getHttpStatus());
	}
	
	/* Patch API */
	
	// for the given id update title for all the products
	// in PUT API we update the whole object in database
	// while in patch API our aim is to update only some of the attributes
	
	@PatchMapping("/patchProduct")
	public ResponseEntity<Void> patchProduct(@RequestBody PatchRequest patchRequest){
		
	    HttpStatus responseStatus =  productService.patchProduct(patchRequest);
		return new ResponseEntity<>(responseStatus);
	
	
	}
	
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<Void> deleteProduct(@RequestBody DeleteRequest deleteRequest){
		 HttpStatus responseStatus = productService.deleteProduct(deleteRequest);
		return new ResponseEntity<>(responseStatus);
	}
	

}
