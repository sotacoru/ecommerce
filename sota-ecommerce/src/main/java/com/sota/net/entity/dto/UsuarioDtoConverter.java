package com.sota.net.entity.dto;


import com.sota.net.entity.Usuario;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioDtoConverter {

	private PasswordEncoder passEncoder;
	
	public List<GetUsuarioDto> convertListUsuarioEntityToGetUserDto1(List<Usuario> usuario) {
		List<GetUsuarioDto> user = new ArrayList<>();
		for (Usuario newUser : usuario) {
			user.add(converUsuarioEntityToGetUserDto(newUser));
		}
		return user;
	}
	
	public GetUsuarioDto converUsuarioEntityToGetUserDto(Usuario usuario) {
		GetUsuarioDto user = new GetUsuarioDto(
				usuario.getIdusuario(),
				usuario.getNombre(),
				usuario.getPrimerapellido(),
				usuario.getSegundoapellido(),
				usuario.getEmail(),
				usuario.getPerfil()
				);
		return user;
	}

	public Usuario crearUsuario(CreateUsuarioDto nuevoUsuario) {
		Usuario u= null;
		if(nuevoUsuario.getPassword().contentEquals(nuevoUsuario.getPassword2())) {
			u = new Usuario(
					nuevoUsuario.getNombre(),
					nuevoUsuario.getPrimerApellido(),
					nuevoUsuario.getSegundoApellido(),
					nuevoUsuario.getEmail(),
					passEncoder.encode(nuevoUsuario.getPassword()).toString(),
					nuevoUsuario.getPerfil());

		}else {

		}

		return u;
	}
	public GetUsuarioPedido usuarioPedido(Usuario u){
		return  GetUsuarioPedido.builder().id(u.getIdusuario())
				.nombre(u.getNombre())
				.primerApellido(u.getPrimerapellido())
				.segundoApellido(u.getSegundoapellido())
				.email(u.getEmail())
				.build();

	}

}
