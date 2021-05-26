package com.sota.net.entity.dto;


import com.sota.net.entity.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsarioDtoConverter {

    private PasswordEncoder passEncoder;

    public static GetUsuarioDto converUsuarioEntityToGetUserDto(Usuario usuario) {
        GetUsuarioDto user = new GetUsuarioDto(
                usuario.getNombre(),
                usuario.getPrimerapellido(),
                usuario.getSegundoapellido(),
                usuario.getEmail(),
                usuario.getPerfil(),
                usuario.getPago()
        );
        return user;
    }

    public Usuario crearUsuario(CreateUsuarioDto nuevoUsuario) {
        Usuario u = null;
        if (nuevoUsuario.getPassword().contentEquals(nuevoUsuario.getPassword2())) {
            u = new Usuario(
                    nuevoUsuario.getNombre(),
                    nuevoUsuario.getPrimerApellido(),
                    nuevoUsuario.getSegundoApellido(),
                    nuevoUsuario.getEmail(),
                    this.passEncoder.encode(nuevoUsuario.getPassword()).toString(),
                    nuevoUsuario.getPerfil(),
                    nuevoUsuario.getPago()
            );

        } else {

        }

        return u;
    }

}
