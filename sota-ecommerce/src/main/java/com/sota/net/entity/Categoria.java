package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombrecategoria;

	private String descripcion;

	

	public Categoria(long id, String nombrecategoria, String descripcion) {
		super();
		this.id = id;
		this.nombrecategoria = nombrecategoria;
		this.descripcion = descripcion;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombrecategoria() {
		return nombrecategoria;
	}



	public void setNombrecategoria(String nombrecategoria) {
		this.nombrecategoria = nombrecategoria;
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



	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}



	private static final long serialVersionUID = 1L;
}
