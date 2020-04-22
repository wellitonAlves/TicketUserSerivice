package com.ticket.app.user.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="product-ws")
public interface ProductServiceClient {
	
	@GetMapping("/product")
	public String getProducts();
}
