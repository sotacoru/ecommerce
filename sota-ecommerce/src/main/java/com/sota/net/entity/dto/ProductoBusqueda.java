package com.sota.net.entity.dto;

public class ProductoBusqueda {
    private String nombre;

    private String descripcion;

    private Boolean fotoExist;

    public ProductoBusqueda(String nombre, String descripcion, boolean fotoExist) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoExist = fotoExist;
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
    public Boolean getFotoExist() {
        return fotoExist;
    }

    public void setFotoExist(Boolean fotoExist) {
        this.fotoExist = fotoExist;
    }
}
