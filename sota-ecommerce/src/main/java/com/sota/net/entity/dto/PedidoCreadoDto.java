package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Usuario;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoCreadoDto {
    private Double precioTotal;
    private Usuario idUsuario;
    private Pago idPago;
}
