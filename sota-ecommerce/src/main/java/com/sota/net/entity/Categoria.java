package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	@ApiModelProperty(value="Id de la categoria", dataType = "Long", example="1", position=1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ApiModelProperty(value="Nombre de la categoría del producto", dataType = "String", example="BEBDIAS ALCOHÓLICAS", position=2)
	private String nombrecategoria;

@ApiModelProperty(value="Descripción de la categoría", dataType = "String", example="Bebidas con porcentaje de alcohol superior al 0%", position=3)
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
