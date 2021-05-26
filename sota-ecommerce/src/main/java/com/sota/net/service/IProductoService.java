package com.sota.net.service;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import com.sota.net.entity.dto.ProductoBusqueda;

import java.util.List;

public interface IProductoService {
    abstract List<Producto> findAll();

    abstract Producto findById(Long id);

    abstract Producto save(Producto producto);

    abstract void delete(Long id);

    abstract List<Categoria> findAllCategoria();

    abstract List<Producto> findByCategoria(String categoria);

    abstract List<Producto> findWithFilter(ProductoBusqueda dto);

    abstract List<Producto> findByStock();

    abstract List<Producto> OrderByPricioMax(Double precio);

    abstract List<Producto> OrderByPricioMin(Double precio);

}
