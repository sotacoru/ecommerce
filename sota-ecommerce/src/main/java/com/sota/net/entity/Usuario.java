package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@ApiModelProperty(value="ID del usuario", dataType = "long", example="1", position=1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;

	@ApiModelProperty(value="Nombre del usuario", dataType = "String", example="Pepe", position=2)
	private String nombre;

	@ApiModelProperty(value="Primer apellido del usuario", dataType = "String", example="Rodríguez", position=3)
	private String primerapellido;

	@ApiModelProperty(value="Segundo apellido del usuario", dataType = "String", example="López", position=4)
	private String segundoapellido;

	@ApiModelProperty(value="Email del usuario", dataType = "String", example="email@email.com", position=5)
	@Column(unique = true)
	private String email;

	@ApiModelProperty(value="Contraseña del usuario", dataType = "String", example="Contraseña123.", position=6)
	private String contraseña;

	@ApiModelProperty(value="Perfil asociado al usuario", dataType = "Perfil", example="ADMINISTRADOR", position=7)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idperfil")
	private Perfil perfil;

	@ApiModelProperty(value="Pago favorito elegido por el usuario", dataType = "Pago", example="TARJETA", position=8)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpago")
	private Pago pago;



	public Long getIdusuario() {
		return idusuario;
	}



	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
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



	public String getContraseña() {
		return contraseña;
	}



	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
