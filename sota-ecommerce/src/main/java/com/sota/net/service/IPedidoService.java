package com.sota.net.service;

import com.sota.net.entity.Pedido;

public interface IPedidoService {
	
	abstract Pedido findById(Long id);
	abstract Pedido save(Pedido pedido);
	

}
