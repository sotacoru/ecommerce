package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoCreadoDto {
    private Double precioTotal;
    private GetUsuarioPedido idUsuario;
    private Pago idPago;
}
