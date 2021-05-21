package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private Double precio;
	
	private String descripcion;
	
	private int cantidad;
	
	private String foto;
	
	@JoinColumn(name = "idCategoria")
	private int categoriaProducto;
	
	
	
	
	

	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public Double getPrecio() {
		return precio;
	}






	public void setPrecio(Double precio) {
		this.precio = precio;
	}






	public String getDescripcion() {
		return descripcion;
	}






	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}






	public int getCantidad() {
		return cantidad;
	}






	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}






	public String getFoto() {
		return foto;
	}






	public void setFoto(String foto) {
		this.foto = foto;
	}






	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
