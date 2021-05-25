package com.sota.net.repository;

import com.sota.net.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.nombre like %?1%")
    public List<Usuario> findByNombre(Usuario nombre);

}
