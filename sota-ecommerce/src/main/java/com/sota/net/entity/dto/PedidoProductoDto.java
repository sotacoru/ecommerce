package com.sota.net.entity.dto;

import com.sota.net.entity.Producto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoProductoDto {
	
	@ApiModelProperty(value = "Producto asociado a este pedido", dataType = "Producto", example = "Manzanas golden", position = 2)
    private Producto producto;
	
	@ApiModelProperty(value = "Cantidad del producto seleccionada en el pedido", dataType = "Int", example = "10", position = 3)
    private int cantidad;
}
