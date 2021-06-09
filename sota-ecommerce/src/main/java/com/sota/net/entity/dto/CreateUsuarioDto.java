package com.sota.net.entity.dto;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Perfil;

import io.swagger.annotations.ApiModelProperty;


public class CreateUsuarioDto {

	
	@ApiModelProperty(value = "Nombre del usuario", dataType = "String", example = "Pepe", position = 1)
    private String nombre;
	
	@ApiModelProperty(value = "Primer apellido del usuario", dataType = "String", example = "Rodríguez", position = 2)
    private String primerApellido;
	
	@ApiModelProperty(value = "Segundo apellido del usuario", dataType = "String", example = "López", position = 3)
    private String segundoApellido;
	
	@ApiModelProperty(value = "Email del usuario", dataType = "String", example = "email@email.com", position = 4)
    private String email;
	
	@ApiModelProperty(value = "password del usuario", dataType = "String", example = "password123.", position = 5)
    private String password;
	
	@ApiModelProperty(value = "Comprobación de la contraseña", dataType = "String", example = "password123.", position = 6)
    private String password2;
    
	@ApiModelProperty(value = "Perfil asociado al usuario", dataType = "Perfil", example = "ADMINISTRADOR", position = 7)
    private Perfil perfil;


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

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


}
