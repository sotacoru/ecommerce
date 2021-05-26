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

    private String contrasenha;

    @JsonSerialize
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idperfil")
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpago")
    private Pago pago;


    public Long getIdusuario() {
        return idUsuario;
    }


    public void setIdusuario(Long idusuario) {
        this.idUsuario = idusuario;
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


    public String getContrasenha() {
        return contrasenha;
    }


    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }


    public Perfil getPerfil() {
        return perfil;
    }


    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    public Pago getPago() {
        return pago;
    }


    public void setPago(Pago pago) {
        this.pago = pago;
    }


    private static final long serialVersionUID = 1L;
}
