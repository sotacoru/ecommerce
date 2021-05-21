package com.sota.net.service;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import com.sota.net.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productoService")
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoRepository rep;

	@Override
	public List<Producto> findAll() {
		return rep.findAll();
	}

	@Override
	public Optional<Producto> findById(Long id) {
		return rep.findById(id);
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
	public List<Producto> findByCategoria(int categoriaProducto) {
		return rep.findByCategoria(categoriaProducto);
	}

	@Override
	public List<Producto> findByStock() {
		return rep.findByStock();
	}

	@Override
	public List<Producto> OrderByNombre(String nombre) {
		return rep.orderByNombre(nombre);
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
