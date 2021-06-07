package com.sota.net.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sota.net.model.UserPerfil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data 
@Table(name = "usuario")
public class Usuario implements Serializable, UserDetails {

	@ApiModelProperty(value = "ID del usuario", dataType = "long", example = "1", position = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@ApiModelProperty(value = "Nombre del usuario", dataType = "String", example = "Pepe", position = 2)
//	@NotNull
//	@Size(min=2, max=20)
	private String nombre;

	@ApiModelProperty(value = "Primer apellido del usuario", dataType = "String", example = "Rodríguez", position = 3)
//	@NotNull
	//@Size(min=2, max=20)
	private String primerapellido;

	@ApiModelProperty(value = "Segundo apellido del usuario", dataType = "String", example = "López", position = 4)
	//@NotNull
	//@Size(min=2, max=20)
	private String segundoapellido;

	@ApiModelProperty(value = "Email del usuario", dataType = "String", example = "email@email.com", position = 5)
	@Column(unique = true)
	//@NotNull
	//@Size(min=10, max=320)
	private String email;
	
	private int intentos;
	
	private boolean bloqueada;

	@ApiModelProperty(value = "password del usuario", dataType = "String", example = "password123.", position = 6)
	private String password;

	@ApiModelProperty(value = "Perfil asociado al usuario", dataType = "Perfil", example = "ADMINISTRADOR", position = 7)
	@JsonSerialize
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idperfil")
	private Perfil perfil;
	
	public Usuario(String nombre, String primerapellido, String segundoapellido, String email, String password,
			int intentos, boolean bloqueada, Perfil perfil) {
		this.nombre = nombre;
		this.primerapellido = primerapellido;
		this.segundoapellido = segundoapellido;
		this.email = email;
		this.password = password;
		this.intentos = intentos;
		this.bloqueada = bloqueada;
		this.perfil = perfil;
	}
	

    public Long getIdusuario() {
		return idUsuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idUsuario = idusuario;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public int getIntentos() {
		return intentos;
	}
	
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	
	public boolean getBloqueada() {
		return bloqueada;
	}
	
	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// @formatter:off
		
		@SuppressWarnings("static-access")
		List<GrantedAuthority> auths = Arrays.asList(UserPerfil.values()).stream()
				.map(ur -> new SimpleGrantedAuthority("ROLE_"+ur.name())).collect(Collectors.toList());
		return auths;
		
		// @formatter:on
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Usuario() {
	}


	public Usuario(Long idUsuario, String nombre, String primerApellido, String segundoApellido, String email) {
		this.idUsuario=idUsuario;
		this.nombre=nombre;
		this.primerapellido=primerApellido;
		this.segundoapellido=segundoApellido;
		this.email=email;
	}


	private static final long serialVersionUID = 1L;
}
