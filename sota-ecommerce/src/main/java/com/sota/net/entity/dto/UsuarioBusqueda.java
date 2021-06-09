package com.sota.net.entity.dto;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioBusqueda {
	
	@ApiModelProperty(value = "Nombre del usuario", dataType = "String", example = "Pepe", position = 1)
    private String nombre;
	
	@ApiModelProperty(value = "Primer apellido del usuario", dataType = "String", example = "Rodríguez", position = 2)
    private String primerapellido;
	
	@ApiModelProperty(value = "Segundo apellido del usuario", dataType = "String", example = "López", position = 3)
    private String segundoapellido;
	
	@ApiModelProperty(value = "Email del usuario", dataType = "String", example = "email@email.com", position = 4)
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
