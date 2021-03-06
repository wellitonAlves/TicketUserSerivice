package com.ticket.app.user.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ticket.app.user.data.ProductServiceClient;
import com.ticket.app.user.data.UsersRepository;
import com.ticket.app.user.entity.UserEntity;
import com.ticket.app.user.service.UsersService;
import com.ticket.app.user.shared.ProductDto;
import com.ticket.app.user.shared.UserDto;


@Service
public class UsersServiceImpl implements UsersService {
		
	UsersRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	ProductServiceClient productServiceClient;
	

	@Autowired
	public UsersServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UsersRepository userRepository, ProductServiceClient productServiceClient) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.productServiceClient = productServiceClient;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		
		userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		
		
		userRepository.save(userEntity);
		
		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
		
		
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(username);
		
		if(userEntity == null)
			throw new UsernameNotFoundException(username);
		
		return new User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true , new ArrayList<>());
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null)
			throw new UsernameNotFoundException(email);
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}
	
	@Override
	public List<ProductDto> getProductsByUserId(String userId) {
		
		List<ProductDto> productListList = productServiceClient.getProducts(userId);
               
        return productListList;

	}
	
	
}