package com.sota.net.entity.dto;


import com.sota.net.entity.Pago;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto {
    private long id;
    private Double precioTotal;
    private int realizado;
    private GetUsuarioPedido idUsuario;

    private Pago idPago;

}
