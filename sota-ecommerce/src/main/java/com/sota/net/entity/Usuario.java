package com.sota.net.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;

    private String primerapellido;

    private String segundoapellido;

    @Column(unique = true)
    private String email;

    private String password;

    @JsonSerialize
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idperfil")
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpago")
    private Pago pago;


    public Long getIdusuario() {
        return this.idUsuario;
    }


    public void setIdusuario(Long idusuario) {
        this.idUsuario = idusuario;
    }


    public String getNombre() {
        return this.nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPrimerapellido() {
        return this.primerapellido;
    }


    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }


    public String getSegundoapellido() {
        return this.segundoapellido;
    }


    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return this.password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Perfil getPerfil() {
        return this.perfil;
    }


    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    public Pago getPago() {
        return this.pago;
    }


    public void setPago(Pago pago) {
        this.pago = pago;
    }


    private static final long serialVersionUID = 1L;
}
