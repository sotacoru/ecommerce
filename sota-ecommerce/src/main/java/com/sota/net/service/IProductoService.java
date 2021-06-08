package com.sota.net.service;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import com.sota.net.entity.dto.ProductoBusqueda;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    abstract List<Producto> findAll();

    abstract Optional<Producto> findById(Long id);

    abstract Producto save(Producto producto);

    abstract void delete(Long id);

    abstract List<Categoria> findAllCategoria();

    abstract List<Producto> findByCategoria(String categoria);

    abstract List<Producto> findWithFilter(ProductoBusqueda dto);

    abstract void updateStock(Producto p, int cantidad);


}
