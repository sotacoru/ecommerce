package com.sota.net.service;

import com.sota.net.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
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
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println(email);
		Usuario u = usuarioService.findByEmail(email);
		System.out.println("fjdfkdfldfkdflk");
		if(u!=null) {
			return u;
		}

		return (UserDetails) new UsernameNotFoundException(email + " no encontrado");
	}

	public UserDetails loadUserById(Long id) throws UsernameNotFoundException{
		Usuario u = usuarioService.findById(id);

		if(u!=null) {
			return u;
		}

		return (UserDetails) new UsernameNotFoundException("ID: " + id + " no encontrado");
	}

}
