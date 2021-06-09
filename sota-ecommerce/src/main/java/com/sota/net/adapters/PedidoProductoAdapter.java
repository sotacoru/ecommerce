package com.sota.net.adapters;

import com.sota.net.entity.PedidoProducto;
import com.sota.net.entity.dto.PedidoProductoDto;

import java.util.ArrayList;
import java.util.List;

public class PedidoProductoAdapter {
    public static List<PedidoProducto> adapterPedidoProductoLista(List<PedidoProductoDto> productos) {
        List<PedidoProducto> productospedido = new ArrayList<>();
        for (PedidoProductoDto producto: productos) {
            PedidoProducto pedidoProducto = new PedidoProducto();
            pedidoProducto.setCantidad(producto.getCantidad());
            pedidoProducto.setProducto(producto.getProducto());
            productospedido.add(pedidoProducto);

        }
        return productospedido;
    }
    public static List<PedidoProductoDto> adapterPedidoProductoDtoLista(List<PedidoProducto> productos) {
        List<PedidoProductoDto> productospedido = new ArrayList<>();
        for (PedidoProducto producto : productos) {
            PedidoProductoDto pedidoProducto = new PedidoProductoDto();
            pedidoProducto.setCantidad(producto.getCantidad());
            pedidoProducto.setProducto(producto.getProducto());
            productospedido.add(pedidoProducto);

        }
        return productospedido;
    }
}
