package com.sota.net.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	@ApiModelProperty(value = "ID del pedido", dataType = "Int", example = "1", position = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ApiModelProperty(value = "Precio total del pedido", dataType = "Double", example = "10000", position = 2)
	private Double precioTotal;
	
	@ApiModelProperty(value = "Ver si el pedido fue realizado (0 no realizado; 1 realizado)", dataType = "Int", example = "0 (Está en la cesta)", position = 3)
	private int realizado;

	@ApiModelProperty(value = "Id del usuario que realiza el pedido", dataType = "Int", example = "1", position = 4)
	@JoinColumn(name = "idusuario")
	@OneToOne
	private Usuario idUsuario;

	@ApiModelProperty(value = "Id del pago utilizado por el cliente", dataType = "Int", example = "1", position = 5)
	@JoinColumn(name = "idpago")
	@ManyToOne(fetch = FetchType.LAZY)
	private Pago idPago;

	public Pedido(long id, Double precioTotal, int realizado, Usuario idUsuario, Pago idPago) {
		this.id = id;
		this.precioTotal = precioTotal;
		this.realizado = realizado;
		this.idUsuario = idUsuario;
		this.idPago = idPago;
	}

	public Pedido() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getRealizado() {
		return realizado;
	}

	public void setRealizado(int realizado) {
		this.realizado = realizado;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Pago getIdPago() {
		return idPago;
	}

	public void setIdPago(Pago idPago) {
		this.idPago = idPago;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
