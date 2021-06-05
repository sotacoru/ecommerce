package com.sota.net.entity.dto;


import com.sota.net.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioDtoConverter {

	private PasswordEncoder passEncoder;
	
	public GetUsuarioDto converUsuarioEntityToGetUserDto(Usuario usuario) {
		System.out.println(usuario.getEmail() + " ");
		GetUsuarioDto user = new GetUsuarioDto(
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
		return  new GetUsuarioPedido(u.getIdusuario(),
			u.getNombre(),
			u.getPrimerapellido(),
				u.getSegundoapellido(),
			u.getEmail());

	}
	public Usuario usuarioPedidoToUsuario(GetUsuarioPedido usuarioPedido){
		return new Usuario(
				usuarioPedido.getIdUsuario(),
				usuarioPedido.getNombre(),
				usuarioPedido.getPrimerApellido(),
				usuarioPedido.getSegundoApellido(),
				usuarioPedido.getEmail());

	}

}
