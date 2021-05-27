package com.sota.net.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	@ApiModelProperty(value = "id del producto", dataType = "Long", example = "1", position = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long id;

	@ApiModelProperty(value = "Nombre del producto", dataType = "String", example = "CERVEZA DE CEBADA", position = 2)
    private String nombre;

	@ApiModelProperty(value = "Precio por unidad del producto", dataType = "Double", example = "2,5", position = 3)
    private Double precio;

	@ApiModelProperty(value = "Pago favorito elegido por el usuario", dataType = "String", example = "Cerveza hecha a partir de cebada", position = 4)
    private String descripcion;

	@ApiModelProperty(value = "Cantidad disponible del producto", dataType = "Int", example = "10", position = 5)
    private int cantidad;
    

	@ApiModelProperty(value = "Ruta en donde se alamcena la imagen", dataType = "String", example = "ruta/foto.jpg", position = 6)
    private String foto;

	 @OneToMany( mappedBy = "producto")
	 private List<PedidoProducto> pedidoProducto;


	@ApiModelProperty(value = "Categoría a la que pertenece el producto", dataType = "Categoria", example = "BEBIDAS ALCOHÓLICAS", position = 7)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoria")

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
