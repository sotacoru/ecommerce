package com.sota.net.service;

import java.util.List;

import com.sota.net.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByName(String nombre);
	 
	public Usuario findById(Long idUsuario);
	
	public Usuario save(Usuario usuario);
	
	public List<Usuario> findAll();
	
	public void delete(Long idUsuario);
}
