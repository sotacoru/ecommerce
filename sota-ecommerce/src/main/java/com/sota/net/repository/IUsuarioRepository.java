package com.sota.net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sota.net.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.nombre like %?1%")
	public List<Usuario> findByNombre (Usuario nombre);

	@Query("from Usuario")
	public List<Usuario> findAllUsuarios();
	
	@Query("select u from Usuario u where u.id = ?1")
	public void deleteById(Long idUsuario);
	
	@Query("select u from Usuario u where u.id = ?1")
	public Usuario updateById(Usuario idUsuario);
	
	@Query("select u from Usuario u where u.id = ?1")
	public Usuario findById(Usuario idUsuario);
}
