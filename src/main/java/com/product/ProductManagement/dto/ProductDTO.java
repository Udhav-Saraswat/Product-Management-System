package com.product.ProductManagement.dto;

import org.springframework.http.HttpStatus;

public class ProductDTO {
	
	private String result;
	private HttpStatus httpStatus;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	

}
