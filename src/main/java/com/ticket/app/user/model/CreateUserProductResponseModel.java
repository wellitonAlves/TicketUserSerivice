package com.ticket.app.user.model;

import java.util.List;

import com.ticket.app.user.shared.ProductDto;

public class CreateUserProductResponseModel {
	
	private List<ProductDto> products;
	
	public List<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	
	
}
