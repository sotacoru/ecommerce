package com.sota.net.repository;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {


    @Query("select p from Producto p where p.idcategoria.nombrecategoria like ?1")
    public List<Producto> findByCategoria(String categoria);


    @Query("from Categoria")
    public List<Categoria> findAllCategoria();


}




