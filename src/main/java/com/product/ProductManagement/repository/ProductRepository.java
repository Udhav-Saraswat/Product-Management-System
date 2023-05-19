package com.product.ProductManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.product.ProductManagement.entity.Products;

@Repository
public interface ProductRepository extends MongoRepository<Products, Integer> {
	

}
