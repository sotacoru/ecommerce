package com.sota.net.entity.dto;


public class UsuarioBusqueda {
    private String nombre;
    private String primerapellido;
    private String segundoapellido;
    private String email;

    public UsuarioBusqueda(String nombre, String primerapellido, String segundoapellido, String email) {
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.email = email;
    }

    public UsuarioBusqueda() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmpty() {
        return this.nombre == null && this.primerapellido == null && this.segundoapellido == null && this.email==null;
    }
}
