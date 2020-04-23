package com.ticket.app.user.shared;

import org.springframework.stereotype.Component;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
	
	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 400:
			// return new BadRequestException();
			break;
		case 404: {
			if (methodKey.contains("getProducts")) {
				return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Products are not found");
			}
			break;
		}
		default:
			return new Exception(response.reason());
		}
		return null;
	}

}