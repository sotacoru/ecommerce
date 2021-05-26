package com.sota.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sota.net.entity.Pedido;

import com.sota.net.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private PedidoRepository rep;

	@Override
	public Pedido findById(Long id) {
		return rep.findById(id).orElse(null);
	}

	
	
}
