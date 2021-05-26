package com.sota.net.service;

import com.sota.net.entity.Usuario;
import com.sota.net.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario u = this.usuarioService.findByEmail(email);

        if (u != null) {
            return (UserDetails) u;
        }

        return (UserDetails) new UsernameNotFoundException(email + " no encontrado");
    }

}
