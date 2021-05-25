package com.sota.net.service;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;

import java.util.List;


public interface IProductoService {
	abstract List<Producto> findAll();

	abstract Producto findById(Long id);

	abstract Producto save(Producto producto);

	abstract void delete(Long id);

	abstract List<Categoria> findAllCategoria();

	abstract List<Producto> findByNombre(String nombre);
	abstract List<Producto> findByDescripcion(String term);
  
	abstract List<Producto> findByNombreAndDescripcion(String nombre, String term);
	abstract List<Producto> findIfFotoIsNotNull();
	abstract List<Producto> findByNombreAndFotoIsNotNull(String foto);
	abstract List<Producto>  findByDescripcionAndFotoIsNotNull(String descripcion);
	abstract List<Producto>  findByDescripcionAndNombreAndFotoIsNotNull(String foto, String descripcion);

	abstract List<Producto> findByStock();

	abstract List<Producto> OrderByPricioMax(Double precio);

	abstract List<Producto> OrderByPricioMin(Double precio);

}
