package com.sota.net.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombrecategoria;

    private String descripcion;


    public Categoria(long id, String nombrecategoria, String descripcion) {
        super();
        this.id = id;
        this.nombrecategoria = nombrecategoria;
        this.descripcion = descripcion;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNombrecategoria() {
        return nombrecategoria;
    }


    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
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


    public Categoria() {
        super();
        // TODO Auto-generated constructor stub
    }


    private static final long serialVersionUID = 1L;
}
