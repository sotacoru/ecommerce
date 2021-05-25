package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Perfil;


public class CreateUsuarioDto {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String email;
	private String contraseña;
	private String contraseña2;
	private Perfil perfil;
	private Pago pago;
	
	public CreateUsuarioDto() {
	}
	
	public CreateUsuarioDto(String nombre, String primerApellido, String segundoApellido, String email,
			String contraseña, String contraseña2, Pago pago) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.email = email;
		this.contraseña = contraseña;
		this.contraseña2 = contraseña2;
		this.pago = pago;
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
	
	public String getContraseña2() {
		return contraseña2;
	}
	
	public void setContraseña2(String contraseña2) {
		this.contraseña2 = contraseña2;
	}
	
	public Pago getPago() {
		return pago;
	}
	
	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
}
