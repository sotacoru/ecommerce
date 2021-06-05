package com.sota.net.entity.dto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUsuarioPedido {
    private Long idUsuario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;

}
