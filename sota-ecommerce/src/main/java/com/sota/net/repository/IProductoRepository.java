package com.sota.net.repository;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {
    /*
        @Query("select p from Producto p where  p.nombre like %?1%")
        public List<Producto> findByNombre(String nombre);
        @Query("select p from Producto p where p.nombre like %?1% and p.descripcion like %?2%")
        public List<Producto> findByNombreAndDescripcion(String nombre, String term);
        @Query("select p from Producto p where  p.descripcion like %?1%")
        public List<Producto> findByDescripcion(String term);
        @Query("select p from Producto p where  p.descripcion like %?1% and p.foto IS NOT NULL ")
        public List<Producto> findByDescripcionAndFotoNotNull(String term);
        @Query("select p from Producto p where  p.descripcion like %?1% and p.foto IS NOT NULL ")
        public List<Producto> findByNombreAndFotoNotNull(String nombre);
        @Query("select p from Producto p where p.nombre like %?1% and p.descripcion like %?2% and p.foto IS NOT NULL ")
        public List<Producto> findByNombreAndDescripcionAndFotoNotNull(String nombre, String term);
        @Query("select p from Producto p where  p.foto IS NOT NULL")
        public List<Producto> findIfFotoIsNotNull();
    */
    @Query("select p from Producto p where  p.cantidad > 0")
    public List<Producto> findByStock();

    @Query("select p from Producto p ORDER BY p.precio ASC")
    public List<Producto> orderByPricioMax(Double precio);

    @Query("select p from Producto p ORDER BY p.precio DESC")
    public List<Producto> orderByPricioMin(Double precio);

    @Query("from Categoria")
    public List<Categoria> findAllCategoria();


}




