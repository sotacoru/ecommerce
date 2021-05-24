package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idperfil")
	private Long idperfil;

	@Column(name = "nombreperfil")
	private String nombreperfil;

	@Column(name = "descripcion")
	private String descripcion;

	public Long getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(Long idperfil) {
		this.idperfil = idperfil;
	}

	public String getNombreperfil() {
		return nombreperfil;
	}

	public void setNombreperfil(String nombreperfil) {
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
