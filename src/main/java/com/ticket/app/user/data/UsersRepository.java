package com.ticket.app.user.data;

import org.springframework.data.repository.CrudRepository;

import com.ticket.app.user.entity.UserEntity;


public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
	
}
