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
@Table(name = "pago")
public class Pago implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID del pago", dataType = "long", example = "1", position = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "idpago")
	private Long idpago;

	@ApiModelProperty(value = "Tipo del pago", dataType = "String", example = "CONTRAREEMBOLSO", position = 2)
	@Column(name = "tipopago")
	private String tipopago;

	@ApiModelProperty(value = "Descripción del pago", dataType = "String", example = "Pago en mano de la empresa de reparto", position = 3)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdpago() {
		return idpago;
	}

	public void setIdpago(Long idpago) {
		this.idpago = idpago;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
