package com.sota.net.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	@ApiModelProperty(value = "ID de la categoria", dataType = "Int", example = "1", position = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@ApiModelProperty(value = "Nombre de la categoría", dataType = "String", example = "BEBIDAS ALCOHÓLICAS", position = 2)
    private String nombrecategoria;

	@ApiModelProperty(value = "Descripción de la categoría", dataType = "String", example = "Bebidas con porcentaje de alcohol superior al 0%", position = 3)
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
