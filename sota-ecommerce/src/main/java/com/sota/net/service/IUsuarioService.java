package com.sota.net.service;

import java.util.List;

import com.sota.net.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByNombre(Usuario nombre);
	 
	public Usuario findById(Long idUsuario);
	
	public Usuario save(Usuario usuario);
	
	public List<Usuario> findAll();
	
	public void deleteUsuarioById(Long idUsuario);
}
