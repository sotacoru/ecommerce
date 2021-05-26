package com.sota.net.repository;

import com.sota.net.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.email like ?1")
    public Usuario finByEmail(String email);

}
