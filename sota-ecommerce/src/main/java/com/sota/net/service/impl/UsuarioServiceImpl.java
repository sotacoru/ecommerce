package com.sota.net.service.impl;

import com.sota.net.entity.Usuario;
import com.sota.net.repository.IUsuarioRepository;
import com.sota.net.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly=true)
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void deleteUsuarioById(Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElse(null);
	}

}
