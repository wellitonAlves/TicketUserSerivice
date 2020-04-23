package com.ticket.app.user.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ticket.app.user.shared.ProductDto;
import com.ticket.app.user.shared.UserDto;

public interface UsersService extends UserDetailsService {
	UserDto createUser(UserDto userDetails);
	UserDto getUserDetailsByEmail(String email);
	List<ProductDto> getProductsByUserId(String userId);
	

}
