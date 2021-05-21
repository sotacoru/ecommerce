package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCategoria")
	private long idCategoria;
	
	private String nombreCategoria;
	
	private String descripcion;
	
	public Categoria() {
	}
	public Categoria(long idCategoria, String nombreCategoria, String descripcion) {
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.descripcion = descripcion;
	}
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;
}
