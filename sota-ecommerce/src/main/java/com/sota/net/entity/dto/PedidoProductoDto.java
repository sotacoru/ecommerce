package com.sota.net.entity.dto;

import com.sota.net.entity.Producto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoProductoDto {
    private Producto producto;
    private int cantidad;
}
