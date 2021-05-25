package com.sota.net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sota.net.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select u from Usuario u where u.email like ?1")
	public Usuario findByEmail(String email);

}
