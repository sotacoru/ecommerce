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
@Table(name = "Perfil")
public class Perfil implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="Id del perfil", dataType = "Long", example="1", position=1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPerfil")
	private Long idPerfil;
	
	@ApiModelProperty(value="Nombre del perfil del usuario", dataType = "String", example="ADMINISTRADOR", position=2)
	@Column( name = "nombrePerfil")
	private String nombrePerfil;
	
	@ApiModelProperty(value="Descripción del perfil del usuario", dataType = "String", example="Usuario con permisos absolutos", position=3)
	@Column( name = "descripcion")
	private String descripcion;


	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
