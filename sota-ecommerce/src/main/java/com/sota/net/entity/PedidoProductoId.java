package com.sota.net.entity;

import java.io.Serializable;




public class PedidoProductoId implements Serializable {
	
	private Long pedido;
	
	private Long producto;

	


	public Long getPedido() {
		return pedido;
	}




	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}




	public Long getProducto() {
		return producto;
	}




	public void setProducto(Long producto) {
		this.producto = producto;
	}




	private static final long serialVersionUID = 1L;

}
