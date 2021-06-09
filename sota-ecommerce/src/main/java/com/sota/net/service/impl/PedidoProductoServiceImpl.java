package com.sota.net.service.impl;

import com.sota.net.entity.PedidoProducto;
import com.sota.net.entity.Producto;
import com.sota.net.repository.PedidoProductoRepository;
import com.sota.net.service.IPedidoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProductoServiceImpl implements IPedidoProductoService {
    @Autowired
    private PedidoProductoRepository rep;
    @Override
    public PedidoProducto save(PedidoProducto pedido) {
        return rep.save(pedido);
    }

    @Override
    public void deleteProducto(Producto p) {
        List<PedidoProducto> productoList = rep.findAll();
        for (PedidoProducto pp: productoList){
            if (pp.getProducto().getId()==p.getId()){
                rep.delete(pp);
            }
        }

    }


}
