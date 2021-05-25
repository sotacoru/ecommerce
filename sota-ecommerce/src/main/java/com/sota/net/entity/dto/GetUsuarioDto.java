package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Perfil;


public class GetUsuarioDto {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String email;
	private Perfil perfil;
	private Pago pago;
	
	public GetUsuarioDto() {
	}

	public GetUsuarioDto(String nombre, String primerApellido, String segundoApellido, String email, Perfil perfil,
			Pago pago) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.email = email;
		this.perfil = perfil;
		this.pago = pago;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public String getEmail() {
		return email;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public Pago getPago() {
		return pago;
	}
	
	
	
}
