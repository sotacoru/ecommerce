package com.sota.net.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sota.net.model.UserPerfil;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id del perfil", dataType = "Long", example = "1", position = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idperfil")
	private Long idperfil;

	@ApiModelProperty(value = "Nombre del perfil del usuario", dataType = "String", example = "ADMINISTRADOR", position = 2)
	@Column(name = "nombreperfil")
	@Enumerated(EnumType.STRING)
	private UserPerfil nombreperfil;

	@ApiModelProperty(value = "Descripción del perfil del usuario", dataType = "String", example = "Usuario con permisos absolutos", position = 3)
	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(Long idperfil) {
		this.idperfil = idperfil;
	}

	public UserPerfil getNombreperfil() {
		return nombreperfil;
	}

	public void setNombreperfil(UserPerfil nombreperfil) {
		this.nombreperfil = nombreperfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
