package com.product.ProductManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.ProductManagement.dto.DeleteRequest;
import com.product.ProductManagement.dto.PatchRequest;
import com.product.ProductManagement.dto.ProductDTO;
import com.product.ProductManagement.entity.Products;
import com.product.ProductManagement.intrface.service.ProductServiceInterface;
import com.product.ProductManagement.repository.ProductRepository;
import com.product.ProductManagement.util.ProductUtil;


@Service
public class ProductService implements ProductServiceInterface {
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductUtil util;

	@Override
	public ProductDTO addProduct(Products products) {
		
		ProductDTO addProduct = new ProductDTO();

		addProduct.setHttpStatus(HttpStatus.CREATED); 
		
		util.addCreatedDate(products);
		
		try {
			
			productRepository.save(products);
			addProduct.setResult("SAVED");
			
		} catch (Exception e) {
			addProduct.setHttpStatus(HttpStatus.BAD_REQUEST); 
			addProduct.setResult("Failed");
		}
		
		return addProduct;
		
	}

	@Override
	public List<Products> getProduct() {
		List<Products> productList = productRepository.findAll();
		return productList;
	}

	@Override
	public ProductDTO updateproduct(Products products) {
		
		ProductDTO updateProduct = new ProductDTO();
		
		updateProduct.setHttpStatus(HttpStatus.CREATED);
		
		List<Products> productList = productRepository.findAll();
		
		List<Integer> ids = new ArrayList<>();
				
		productList.forEach(product ->
		    ids.add(product.getId())
		);
		
       try {
    	   
    	   if(ids.contains(products.getId())) {
    		   productRepository.save(products);
    		   updateProduct.setResult("Updated");
    	   } else {
    		   updateProduct.setResult("Data not fount");
    	   }
			
			
		} catch (Exception e) {
			updateProduct.setResult("Failed");
			updateProduct.setHttpStatus(HttpStatus.BAD_REQUEST); 
		}
       
       return updateProduct;
		
	}

	@Override
	public HttpStatus patchProduct(PatchRequest patchRequest) {
		
		List<Products> productList =  productRepository.findAll();
		
		productList.forEach(product -> {
			if(product.getId() == patchRequest.getId()) {
				product.getProductList().forEach(productElement -> {
					productElement.setTitle(patchRequest.getTitle());
					productRepository.save(product);
				});
			}
		});
		
		return HttpStatus.CREATED;
		
	}

	@Override
	public HttpStatus deleteProduct(DeleteRequest deleteRequest) {
		
		productRepository.deleteById(deleteRequest.getId());
		return HttpStatus.CREATED;
	}
	
	
	
	
	

}
