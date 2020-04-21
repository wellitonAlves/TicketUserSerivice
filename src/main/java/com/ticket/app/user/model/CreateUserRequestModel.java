package com.ticket.app.user.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	
	@NotNull(message="Name cannot be null")
	@Size(min=2, max=16,message="Name must be equal or grater than 8 characters and less then 16 characters")
	private String Name;
	
	@NotNull(message="CPF cannot be null")
	private String cpf;
	
	@Email @NotNull(message="email name cannot be null") 
	private String email;
	
	@NotNull(message="password name cannot be null")
	@Size(min=8, max=16,message="password must be equal or grater than 8 characters and less then 16 characters")
	private String password;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
