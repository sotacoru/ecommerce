package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;

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
public class DtoUsuarioPedido {

	@ApiModelProperty(value = "ID del usuario", dataType = "long", example = "1", position = 1)
	private int idUsuario;
	
	@ApiModelProperty(value = "Nombre del usuario", dataType = "String", example = "Pepe", position = 2)
	private String nombre;
	
	@ApiModelProperty(value = "Primer apellido del usuario", dataType = "String", example = "Rodríguez", position = 3)
	private String primerapellido;
	
	@ApiModelProperty(value = "Segundo apellido del usuario", dataType = "String", example = "López", position = 4)
	private String segundoapellido;
	
	@ApiModelProperty(value = "Email del usuario", dataType = "String", example = "email@email.com", position = 5)
	private String email;
	
}
