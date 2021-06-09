package com.sota.net.adapters;

import com.sota.net.entity.Pedido;
import com.sota.net.entity.Usuario;
import com.sota.net.entity.dto.PedidoCreadoDto;

import java.util.ArrayList;

public class PedidoAdapter {
    public static Pedido getPedido(PedidoCreadoDto pedidoDto, Usuario u) {
        Pedido pedido = new Pedido();

        pedido.setIdUsuario(u);

        pedido.setPrecioTotal(pedidoDto.getPrecioTotal());
        pedido.setIdPago(pedidoDto.getIdPago());
        pedido.setPedidoProducto(new ArrayList<>());
        return pedido;
    }
}
