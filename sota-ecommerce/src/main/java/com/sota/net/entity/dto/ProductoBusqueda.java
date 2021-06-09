package com.sota.net.entity.dto;

import io.swagger.annotations.ApiModelProperty;

public class ProductoBusqueda {
	@ApiModelProperty(value = "Nombre del producto", dataType = "String", example = "CERVEZA DE CEBADA", position = 1)
    private String nombre;

	@ApiModelProperty(value = "Pago favorito elegido por el usuario", dataType = "String", example = "Cerveza hecha a partir de cebada", position = 2)
    private String descripcion;

    @ApiModelProperty(value = "Valor que da si existe la foto o no (1 existe, 0 no)", dataType = "Boolean", example = "10", position = 3)
    private Boolean foto;

    public ProductoBusqueda(String nombre, String descripcion, boolean foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public ProductoBusqueda() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getFoto() {
        return foto;
    }

    public void setFoto(Boolean foto) {
        this.foto = foto;
    }

    public boolean isEmpty() {
        return this.descripcion == null && this.nombre == null && this.foto == null;
    }
}
