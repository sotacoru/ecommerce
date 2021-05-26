package com.sota.net.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpago")
    private Long idpago;

    @Column(name = "tipopago")
    private String tipopago;

    @Column(name = "descripcion")
    private String descripcion;

    public Long getIdpago() {
        return idpago;
    }

    public void setIdpago(Long idpago) {
        this.idpago = idpago;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
