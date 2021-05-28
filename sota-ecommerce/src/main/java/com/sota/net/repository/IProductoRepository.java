package com.sota.net.repository;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

    @Query("select p from Producto p where  p.cantidad > 0")
    public List<Producto> findByStock();

    @Query("select p from Producto p inner join Categoria c where c.nombrecategoria like ?1")
    public List<Producto> findByCategoria(String categoria);

    @Query("select p from Producto p ORDER BY p.precio ASC")
    public List<Producto> orderByPricioMax(Double precio);

    @Query("select p from Producto p ORDER BY p.precio DESC")
    public List<Producto> orderByPricioMin(Double precio);

    @Query("from Categoria")
    public List<Categoria> findAllCategoria();


}




