package com.sota.net.service;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Pedido;
import com.sota.net.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private PedidoRepository rep;

	@Override
	public Pedido findById(Long id) {
		return rep.findById(id).orElse(null);
	}

	@Override
	public Pedido save(Pedido pedido) {
		return this.rep.save(pedido);
	}

	@Override
	public List<Pago> findAllPagos() {
		return rep.getAllPagos();
	}


}
