package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoCreadoDto {
	
	@ApiModelProperty(value = "Precio total del pedido", dataType = "Int", example = "20000", position = 1)
    private Double precioTotal;
	
	@ApiModelProperty(value = "Id del usuario que realizó el pedido", dataType = "Int", example = "1", position = 2)
    private GetUsuarioPedido idUsuario;
	
	@ApiModelProperty(value = "Id del pago realizado", dataType = "Pago", example = "1", position = 3)
    private Pago idPago;
}
