package com.sota.net.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id del perfil", dataType = "Int", example = "1", position = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperfil")
    private Long idperfil;

    @ApiModelProperty(value = "Nombre del perfil", dataType = "String", example = "CLIENTE", position = 2)
    @Column(name = "nombreperfil")
    private String nombreperfil;

    @ApiModelProperty(value = "Descripción del perfil", dataType = "String", example = "Usuario que solo puede realizar compras", position = 3)
    @Column(name = "descripcion")
    private String descripcion;
    
    public Perfil() {
    	
    }
    
    public Perfil(Long idperfil, String nombreperfil) {
    	this.idperfil= idperfil;
    	this.nombreperfil=nombreperfil;
    }

    public Long getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Long idperfil) {
        this.idperfil = idperfil;
    }

    public String getNombreperfil() {
        return nombreperfil;
    }

    public void setNombreperfil(String nombreperfil) {
        this.nombreperfil = nombreperfil;
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


}
