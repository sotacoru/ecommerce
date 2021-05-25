package com.sota.net.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double precioTotal;
    private int realizado;
    @JoinColumn("idusuario")
    @OneToOne
    private Usuario idUsuario;
    @JoinColumn("idpago")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Pago> idPago;

    public Pedido(long id, Double precioTotal, int realizado, Usuario idUsuario, List<Pago> idPago) {
        this.id = id;
        this.precioTotal = precioTotal;
        this.realizado = realizado;
        this.idUsuario = idUsuario;
        this.idPago = idPago;
    }

    public Pedido() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getRealizado() {
        return realizado;
    }

    public void setRealizado(int realizado) {
        this.realizado = realizado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Pago> getIdPago() {
        return idPago;
    }

    public void setIdPago(List<Pago> idPago) {
        this.idPago = idPago;
    }
}
