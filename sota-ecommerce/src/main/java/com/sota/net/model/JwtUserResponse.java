package com.sota.net.model;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Perfil;
import com.sota.net.entity.dto.GetUsuarioDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUsuarioDto{

	private String token;
	
	@Builder(builderMethodName = "jwtUserResponseBuilder")
	public JwtUserResponse(String nombre, String primerApellido, String segundoApellido, 
			String email, Perfil perfil, Pago pago, String token) {
		super(nombre, primerApellido, segundoApellido, email, perfil, pago);
		this.token = token;
	}
	
}
