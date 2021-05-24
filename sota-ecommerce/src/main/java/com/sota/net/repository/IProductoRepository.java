package com.sota.net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

	@Query("select p from Producto p where  p.nombre like %?1% ")
	public List<Producto> findByNombreContaining(String nombre);

	@Query("select p from Producto p where  p.descripcion like %?1%")
	public List<Producto> findByDescripcionContaining(String term);
	@Query("select p from Producto p where  p.categoriaProducto = ?1")
	public List<Producto> findByCategoria(int categoriaProducto);

	@Query("select p from Producto p where  p.cantidad > 0")
	public List<Producto> findByStock();

	@Query("select p from Producto p ORDER BY p.nombre")
	public List<Producto> orderByNombre(String nombre);

	@Query("select p from Producto p ORDER BY p.precio ASC")
	public List<Producto> orderByPricioMax(Double precio);

	@Query("select p from Producto p ORDER BY p.precio DESC")
	public List<Producto> orderByPricioMin(Double precio);

	@Query("from Categoria")
	public List<Categoria> findAllCategoria();

}
