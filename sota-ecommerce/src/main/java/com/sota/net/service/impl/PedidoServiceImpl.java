package com.sota.net.service.impl;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Pedido;
import com.sota.net.repository.PedidoRepository;
import com.sota.net.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private PedidoRepository rep;

    @Override
    public Pedido findById(Long id) {
        return this.rep.getPedidoById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return rep.save(pedido);
    }

    @Override
    public List<Pago> findAllPagos() {
        return rep.getAllPagos();
    }


}
