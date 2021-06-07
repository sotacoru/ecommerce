package com.sota.net.utils.busqueda;

import io.github.jhipster.service.filter.StringFilter;


public class UsuarioCriteria {

    private StringFilter nombre;
    private StringFilter primerapellido;
    private StringFilter segundoapellido;
    private StringFilter email;

    public StringFilter getNombre() {
        return nombre;
    }

    public void setNombre(StringFilter nombre) {
        this.nombre = nombre;
    }

    public StringFilter getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(StringFilter primerapellido) {
        this.primerapellido = primerapellido;
    }

    public StringFilter getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(StringFilter segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public StringFilter getEmail() {
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }
}
