package com.sota.net.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sota.net.entity.Usuario;

import lombok.RequiredArgsConstructor;

@Service("UserDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private UsuarioServiceImpl usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario u = usuarioService.findByEmail(username);
		
		if(u!=null) {
			return u;
		}
		
		return (UserDetails) new UsernameNotFoundException(username + " no encontrado");
	}
	
	public UserDetails loadUserById(Long id) throws UsernameNotFoundException{
		Usuario u = usuarioService.findById(id);
		
		if(u!=null) {
			return u;
		}
		
		return (UserDetails) new UsernameNotFoundException("ID: " + id + " no encontrado");
	}
	
}
