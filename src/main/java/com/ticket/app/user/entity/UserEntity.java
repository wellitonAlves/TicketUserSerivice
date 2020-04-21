package com.ticket.app.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -870703038907889099L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 50)
	private String cpf;
	
	@Column(nullable = false, length = 120, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String ecryptedPassword;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEcryptedPassword() {
		return ecryptedPassword;
	}

	public void setEcryptedPassword(String ecryptedPassword) {
		this.ecryptedPassword = ecryptedPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
