package com.sota.net.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class LoginRequest {

	private String email;
	private String contraseña;
	
}