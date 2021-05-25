package com.sota.net.entity.dto;


import org.springframework.stereotype.Component;

import com.sota.net.entity.Usuario;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;

@Component
@RequiredArgsConstructor
public class UsuarioDtoConverter {
	
	private PasswordEncoder passEncoder;

	public GetUsuarioDto converUsuarioEntityToGetUserDto(Usuario usuario) {
		GetUsuarioDto user = new GetUsuarioDto(
				usuario.getNombre(),
				usuario.getPrimerapellido(),
				usuario.getSegundoapellido(),
				usuario.getEmail(),
				usuario.getPerfil(),
				usuario.getPago()
				);
		return user;		
	}
	
	public Usuario crearUsuario(CreateUsuarioDto nuevoUsuario) {
		Usuario u = null;
		if(nuevoUsuario.getContraseña().contentEquals(nuevoUsuario.getContraseña2())) {
			u = new Usuario(
					nuevoUsuario.getNombre(),
					nuevoUsuario.getPrimerApellido(),
					nuevoUsuario.getSegundoApellido(),
					nuevoUsuario.getEmail(),
					passEncoder.encode(nuevoUsuario.getContraseña()).toString(),
					nuevoUsuario.getPerfil(),
					nuevoUsuario.getPago()
					);
			
		}else {
			
		}
		
		return u;
	}
	
}
