package com.sota.net.entity.dto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUsuarioPedido {
	
	@ApiModelProperty(value = "ID del usuario", dataType = "long", example = "1", position = 1)
    private Long idUsuario;
	
	@ApiModelProperty(value = "Nombre del usuario", dataType = "String", example = "Pepe", position = 2)
    private String nombre;
	
	@ApiModelProperty(value = "Primer apellido del usuario", dataType = "String", example = "Rodríguez", position = 3)
    private String primerApellido;
	
	@ApiModelProperty(value = "Segundo apellido del usuario", dataType = "String", example = "López", position = 4)
    private String segundoApellido;
	
	@ApiModelProperty(value = "Email del usuario", dataType = "String", example = "email@email.com", position = 5)
    private String email;

}
