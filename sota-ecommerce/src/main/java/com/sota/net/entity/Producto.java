package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	@ApiModelProperty(value = "Id del producto", dataType = "Long", example = "1", position = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private Long id;

	@ApiModelProperty(value = "Nombre del producto", dataType = "String", example = "Vino", position = 2)
	private String nombre;

	@ApiModelProperty(value = "Precio del vino", dataType = "Double", example = "250", position = 3)
	private Double precio;

	@ApiModelProperty(value = "Descripción del producto", dataType = "String", example = "Vino añejo", position = 4)
	private String descripcion;

	@ApiModelProperty(value = "Cantidad total del producto", dataType = "Int", example = "10", position = 5)
	private int cantidad;

	@ApiModelProperty(value = "Ruta de la foto", dataType = "String", example = "ruta/foto/foto.jpg", position = 6)
	private String foto;

	@ApiModelProperty(value = "Categoría del producto", dataType = "Categoria", example = "BEBIDAS ALCOHOLICAS", position = 7)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Categoria idcategoria;

	public Producto(Long id, String nombre, Double precio, String descripcion, int cantidad, String foto,
			Categoria idcategoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.foto = foto;
		this.idcategoria = idcategoria;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Categoria getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}

	private static final long serialVersionUID = 1L;

}
