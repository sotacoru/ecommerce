package com.sota.net.utils.busqueda;

import io.github.jhipster.service.filter.StringFilter;

public class ProductoCriteria {
    private StringFilter nombre;
    private StringFilter descripcion;
    private StringFilter haveFoto;

    public StringFilter getNombre() {
        return nombre;
    }

    public void setNombre(StringFilter nombre) {
        this.nombre = nombre;
    }

    public StringFilter getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(StringFilter descripcion) {
        this.descripcion = descripcion;
    }

    public StringFilter getHaveFoto() {
        return haveFoto;
    }

    public void setHaveFoto(StringFilter haveFoto) {
        this.haveFoto = haveFoto;
    }
}
