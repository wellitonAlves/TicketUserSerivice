package com.ticket.app.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ticket.app.user.shared.UserDto;

public interface UsersService extends UserDetailsService {
	UserDto createUser(UserDto userDetails);
	UserDto getUserDetailsByEmail(String email);
	

}
