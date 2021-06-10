package com.sota.net.service;

import com.sota.net.entity.PedidoProducto;
import com.sota.net.entity.Producto;


public interface IPedidoProductoService {
    abstract PedidoProducto save(PedidoProducto pedido);
    abstract void deleteProducto(Producto p);
}
