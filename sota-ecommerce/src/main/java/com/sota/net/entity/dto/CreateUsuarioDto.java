package com.sota.net.entity.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Perfil;


public class CreateUsuarioDto {

	@NotNull
	@Size(min=2, max=20)
    private String nombre;
	@NotNull
	@Size(min=2, max=20)
    private String primerApellido;
	@NotNull
	@Size(min=2, max=20)
    private String segundoApellido;
	@NotNull
	@Size(min=10, max=320)
    private String email;
	@NotNull
	@Size(min=6, max=30)
    private String password;
	@NotNull
	@Size(min=10, max=30)
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
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return this.password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Pago getPago() {
        return this.pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


}
