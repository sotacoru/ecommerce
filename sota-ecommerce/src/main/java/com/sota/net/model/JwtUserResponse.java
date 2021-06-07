package com.sota.net.model;

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
	public JwtUserResponse(Long id,String nombre, String primerApellido, String segundoApellido, 
			String email, Perfil perfil, String token) {
		super(id,nombre, primerApellido, segundoApellido, email, perfil);
		this.token = token;
	}
	
}
