package com.sota.net.service.impl;

import com.sota.net.entity.Pedido;
import com.sota.net.repository.PedidoRepository;
import com.sota.net.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private PedidoRepository rep;

    @Override
    public Pedido findById(Long id) {
        return this.rep.findById(id).orElse(null);
    }


}
