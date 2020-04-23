package com.ticket.app.user.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ticket.app.user.shared.ProductDto;

import feign.hystrix.FallbackFactory;

@FeignClient(name="product-ws", fallback=ProductFallback.class)
public interface ProductServiceClient {
	
	@GetMapping("/product/{id}")
	public List<ProductDto> getProducts(@PathVariable String id);
}

@Component
class ProductFallback implements FallbackFactory<String> {

	@Override
	public String create(Throwable cause) {
		return "Error";
	}

}
