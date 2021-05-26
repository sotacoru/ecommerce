package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Perfil;


public class CreateUsuarioDto {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String email;
	private String password;
	private String password2;
	private Perfil perfil;
	private Pago pago;
	
	public CreateUsuarioDto() {
	}
	
	public CreateUsuarioDto(String nombre, String primerApellido, String segundoApellido, String email,
			String password, String password2, Pago pago) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.email = email;
		this.password = password;
		this.password2 = password2;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String Password) {
		this.password = Password;
	}
	
	public String getPassword2() {
		return password2;
	}
	
	public void setPassword2(String password2) {
		this.password2 = password2;
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
