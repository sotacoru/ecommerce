package com.sota.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sota.net.entity.Usuario;

@Service("UserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuario u = usuarioService.findByEmail(username);
		
		if(u!=null) {
			return u;
		}
		
		return (UserDetails) new UsernameNotFoundException(username + " no encontrado");
	}
	
}
