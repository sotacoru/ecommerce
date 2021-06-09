package com.sota.net.entity.dto;

import com.sota.net.entity.Perfil;

import io.swagger.annotations.ApiModelProperty;
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

	@ApiModelProperty(value = "ID del usuario", dataType = "long", example = "1", position = 1)
	private Long idUsuario;
	
	@ApiModelProperty(value = "Nombre del usuario", dataType = "String", example = "Pepe", position = 2)
	private String nombre;
	
	@ApiModelProperty(value = "Primer apellido del usuario", dataType = "String", example = "Rodríguez", position = 3)
	private String primerapellido;
	
	@ApiModelProperty(value = "Segundo apellido del usuario", dataType = "String", example = "López", position = 4)
	private String segundoapellido;
	
	@ApiModelProperty(value = "Email del usuario", dataType = "String", example = "email@email.com", position = 5)
	private String email;
	
	@ApiModelProperty(value = "Perfil asociado al usuario", dataType = "Perfil", example = "ADMINISTRADOR", position = 6)
	private Perfil perfil;
	
	@ApiModelProperty(value = "Información de si el usuario tiene la cuenta bloqueada", dataType = "Boolean (1 bloqueada, 0 no bloqueada)", example = "0", position = 8)
	private boolean bloqueada;
	
	@ApiModelProperty(value = "Intentos del usuario (máximo)", dataType = "Int", example = "3", position = 7)
	private int intentos;
	
	
}
