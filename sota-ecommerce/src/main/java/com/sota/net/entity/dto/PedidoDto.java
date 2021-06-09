package com.sota.net.entity.dto;


import com.sota.net.entity.Pago;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto {
	
	@ApiModelProperty(value = "ID del pedido", dataType = "Int", example = "1", position = 1)
    private long id;
	
	@ApiModelProperty(value = "Precio total del pedido", dataType = "Double", example = "10000", position = 2)
    private Double precioTotal;
	
	@ApiModelProperty(value = "Ver si el pedido fue realizado (0 no realizado; 1 realizado)", dataType = "Int", example = "0 (Está en la cesta)", position = 3)
    private int realizado;
	
	@ApiModelProperty(value = "Id del usuario que realiza el pedido", dataType = "Int", example = "1", position = 4)
    private GetUsuarioPedido idUsuario;
	
	@ApiModelProperty(value = "Lista de los productos que están en el pedido", dataType = "PedidoProducto", example = "10", position = 5)
    private List<PedidoProductoDto> productos;
    
    @ApiModelProperty(value = "Id del pago utilizado por el cliente", dataType = "Int", example = "1", position = 6)
    private Pago idPago;

}
