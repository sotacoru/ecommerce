package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Perfil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUsuarioDto {

	private Long idUsuario;
	private String nombre;
	private String primerapellido;
	private String segundoapellido;
	private String email;
	private Perfil perfil;
	
	
	
}
