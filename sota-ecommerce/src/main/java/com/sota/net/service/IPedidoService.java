package com.sota.net.service;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Pedido;

import java.util.List;

public interface IPedidoService {
	
	abstract Pedido findById(Long id);
	abstract Pedido save(Pedido pedido);
	abstract List<Pago> findAllPagos();
	

}
