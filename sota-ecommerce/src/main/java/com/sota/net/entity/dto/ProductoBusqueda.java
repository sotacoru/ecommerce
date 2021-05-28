package com.sota.net.entity.dto;

public class ProductoBusqueda {
    private String nombre;

    private String descripcion;

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
