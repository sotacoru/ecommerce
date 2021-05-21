package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Pago")
public class Pago implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="ID del pago", dataType = "long", example="1", position=1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPago")
	private Long idPago;
	
	@ApiModelProperty(value="Tipo del pago",dataType = "String", example = "CONTRAREEMBOLSO", position = 2)
	@Column(name = "tipoPago")
	private String tipoPago;
	
	@ApiModelProperty(value="Descripción del pago", dataType = "String" , example="Pago en mano de la empresa de reparto", position = 3)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdPago() {
		return idPago;
	}

	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
