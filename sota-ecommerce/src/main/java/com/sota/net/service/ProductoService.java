package com.sota.net.service;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import com.sota.net.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productoService")
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoRepository rep;

	@Override
	public List<Producto> findAll() {
		return rep.findAll();
	}

	@Override
	public Producto findById(Long id) {
		return rep.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		return rep.save(producto);
	}

	@Override
	public void delete(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Categoria> findAllCategoria() {
		return rep.findAllCategoria();
	}

	@Override
	public List<Producto> findByNombre(String nombre) {
		return rep.findByNombre(nombre);
	}

	@Override
	public List<Producto> findByDescripcion(String term) {
		return rep.findByDescripcion(term);
	}

	@Override
	public List<Producto> findByNombreAndDescripcion(String nombre, String term) {
		return rep.findByNombreAndDescripcion(nombre, term);
	}

	@Override
	public List<Producto> findIfFotoIsNotNull() {
		return rep.findIfFotoIsNotNull();
	}

	@Override
	public List<Producto> findByNombreAndFotoIsNotNull(String nombre) {
		return rep.findByNombreAndFotoNotNull(nombre);
	}

	@Override
	public List<Producto> findByDescripcionAndFotoIsNotNull(String term) {
		return rep.findByDescripcionAndFotoNotNull(term);
	}

	@Override
	public List<Producto> findByDescripcionAndNombreAndFotoIsNotNull(String nombre, String term) {
		return rep.findByNombreAndDescripcionAndFotoNotNull(nombre, term);
	}


	@Override
	public List<Producto> findByStock() {
		return rep.findByStock();
	}


	@Override
	public List<Producto> OrderByPricioMax(Double precio) {
		return rep.orderByPricioMax(precio);
	}

	@Override
	public List<Producto> OrderByPricioMin(Double precio) {
		return rep.orderByPricioMin(precio);
	}

	
}
