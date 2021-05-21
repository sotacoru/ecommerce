package com.sota.net.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {

	@ApiModelProperty(value="ID del usuario", dataType = "long", example="1", position=1)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;

	@ApiModelProperty(value="Nombre del usuario", dataType = "String", example="Pepe", position=2)
	private String nombre;

	@ApiModelProperty(value="Primer apellido del usuario", dataType = "String", example="Rodríguez", position=3)
	private String primerApellido;

	@ApiModelProperty(value="Segundo apellido del usuario", dataType = "String", example="López", position=4)
	private String segundoApellido;

	@ApiModelProperty(value="Email del usuario", dataType = "String", example="email@email.com", position=5)
	@Column(unique = true)
	private String email;

	@ApiModelProperty(value="Contraseña del usuario", dataType = "String", example="Contraseña123.", position=6)
	private String contraseña;

	@ApiModelProperty(value="Perfil asociado al usuario", dataType = "Perfil", example="ADMINISTRADOR", position=7)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="Perfil")
	@JoinColumn(name="idPerfil")
	private Perfil perfil;

	@ApiModelProperty(value="Pago favorito elegido por el usuario", dataType = "Pago", example="TARJETA", position=8)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="Pago")
	@JoinColumn(name="idPago")
	private Pago pago;

	
	// Metodos getter y setter
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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

	public Pago getIdPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	private static final long serialVersionUID = 1L;
}
