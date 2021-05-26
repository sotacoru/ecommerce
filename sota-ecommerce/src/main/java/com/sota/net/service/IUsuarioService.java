package com.sota.net.service;

import com.sota.net.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario findByEmail(String email);

    public Usuario findById(Long idUsuario);

    public Usuario save(Usuario usuario);

    public List<Usuario> findAll();

    public void deleteUsuarioById(Long idUsuario);
}
