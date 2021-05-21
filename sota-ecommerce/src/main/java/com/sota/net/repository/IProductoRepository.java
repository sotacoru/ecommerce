package com.sota.net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Long> {

	@Query("select p from Producto p where  p.nombre like %?1%")
	public List<Producto> findByNombre(String nombre);

	@Query("select p from Producto p where  p.descripcion like %?1%")
	public List<Producto> findByDescripcion(String term);

	// public List<Producto> findByCategoria(int categoriaProducto);

	@Query("select p from Producto p where  p.cantidad > 0")
	public List<Producto> findByStock(int cantidad);

	@Query("select p from Producto p ORDER BY p.nombre")
	public List<Producto> OrderByNombre(String nombre);

	@Query("select p from Producto p ORDER BY p.precio ASC")
	public List<Producto> OrderByPricioMax(Double precio);

	@Query("select p from Producto p ORDER BY p.precio DESC")
	public List<Producto> OrderByPricioMin(Double precio);

	@Query("from Categoria")
	public List<Categoria> findAllCategoria();

}
