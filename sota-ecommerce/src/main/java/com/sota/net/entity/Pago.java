package com.sota.net.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID del pago", dataType = "Int", example = "1", position = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpago")
    private Long idpago;

    @ApiModelProperty(value = "Tipo de pago utilizado", dataType = "String", example = "TARJETA", position = 2)
    @Column(name = "tipopago")
    private String tipopago;

    @ApiModelProperty(value = "Descripción del tipo de pago utilizado", dataType = "String", example = "Pago utilizando la tarjeta", position = 3)
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
