package com.sota.net.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sota.net.model.UserPerfil;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
	private String nombre;

	@ApiModelProperty(value = "Primer apellido del usuario", dataType = "String", example = "Rodríguez", position = 3)
	private String primerapellido;

	@ApiModelProperty(value = "Segundo apellido del usuario", dataType = "String", example = "López", position = 4)
	private String segundoapellido;

	@ApiModelProperty(value = "Email del usuario", dataType = "String", example = "email@email.com", position = 5)
	@Column(unique = true)
	private String email;

	@ApiModelProperty(value = "password del usuario", dataType = "String", example = "password123.", position = 6)
	private String password;

	@ApiModelProperty(value = "Perfil asociado al usuario", dataType = "Perfil", example = "ADMINISTRADOR", position = 7)
	@JsonSerialize
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idperfil")
	private Perfil perfil;

	@ApiModelProperty(value = "Pago favorito elegido por el usuario", dataType = "Pago", example = "TARJETA", position = 8)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpago")
	private Pago pago;

	public Usuario(String nombre, String primerapellido, String segundoapellido, String email, String password,
			Perfil perfil, Pago pago) {
		this.nombre = nombre;
		this.primerapellido = primerapellido;
		this.segundoapellido = segundoapellido;
		this.email = email;
		this.password = password;
		this.perfil = perfil;
		this.pago = pago;
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

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
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

    private static final long serialVersionUID = 1L;
}
