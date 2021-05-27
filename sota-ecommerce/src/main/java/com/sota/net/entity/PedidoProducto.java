package com.sota.net.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
@Table(name = "pedido_producto")
@IdClass(PedidoProductoId.class)
public class PedidoProducto implements Serializable {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	private Pedido pedido;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", referencedColumnName = "idproducto")
	private Producto producto;

	private int cantidad;

	public PedidoProducto(Pedido pedido, Producto producto, int cantidad) {
		super();
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public PedidoProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProdcuto() {
		return producto;
	}

	public void setProdcuto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	private static final long serialVersionUID = 1L;
}
