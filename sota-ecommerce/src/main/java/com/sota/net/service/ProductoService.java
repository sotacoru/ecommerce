package com.sota.net.service;

import com.sota.net.entity.Categoria;

import com.sota.net.entity.Producto;
//import com.sota.net.entity.Producto_;
import com.sota.net.entity.dto.ProductoBusqueda;
import com.sota.net.repository.*;
import com.sota.net.utils.busqueda.ProductoCriteria;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("productoService")
public class ProductoService extends QueryService implements IProductoService {


    @Autowired
    private IProductoRepository rep;

    @Override
    public List<Producto> findAll() {
        return this.rep.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return this.rep.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return this.rep.save(producto);
    }

    @Override
    public void delete(Long id) {
        this.rep.deleteById(id);
    }

    @Override
    public List<Categoria> findAllCategoria() {
        return this.rep.findAllCategoria();
    }


	@Override
	public List<Producto> findWithFilter(ProductoBusqueda dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findByStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> OrderByPricioMax(Double precio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> OrderByPricioMin(Double precio) {
		// TODO Auto-generated method stub
		return null;
	}
}
