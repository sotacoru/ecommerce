package com.sota.net.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long id;

    private String nombre;

    private Double precio;

    private String descripcion;

    private int cantidad;
    

    private String foto;
    
	 @OneToMany( mappedBy = "producto")
	 private List<PedidoProducto> pedidoProducto;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoria")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria idcategoria;


    public Producto(Long id, String nombre, Double precio, String descripcion, int cantidad, String foto,
                    Categoria idcategoria) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.foto = foto;
        this.idcategoria = idcategoria;
    }


    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public String getFoto() {
        return foto;
    }


    public void setFoto(String foto) {
        this.foto = foto;
    }


    public Categoria getIdcategoria() {
        return idcategoria;
    }


    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    
    

	public List<PedidoProducto> getPedidoProducto() {
		return pedidoProducto;
	}


	public void setPedidoProducto(List<PedidoProducto> pedidoProducto) {
		this.pedidoProducto = pedidoProducto;
	}




	private static final long serialVersionUID = 1L;

}
