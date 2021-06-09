package com.sota.net.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedido_producto")
@IdClass(PedidoProductoId.class)
public class PedidoProducto implements Serializable {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	@JsonIgnore
	@ApiModelProperty(value = "Categoría a la que pertenece el producto", dataType = "Categoria", example = "BEBIDAS ALCOHÓLICAS", position = 7)
	private Pedido pedido;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", referencedColumnName = "idproducto")
	@ApiModelProperty(value = "Producto asociado a este pedido", dataType = "Producto", example = "Manzanas golden", position = 2)
	private Producto producto;

	@ApiModelProperty(value = "Cantidad del producto seleccionada en el pedido", dataType = "Int", example = "10", position = 3)
	private int cantidad;

	public PedidoProducto(Pedido pedido, Producto producto, int cantidad) {
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public PedidoProducto() { }

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
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
