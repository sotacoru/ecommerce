package com.sota.net.service;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
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
        if (dto.isEmpty()) {
            return Collections.emptyList();
        }
        final Specification<Producto> specification = this.createSpecification(ProductoService.createCriteria(dto));
        List<Producto> productos = this.rep.findAll(specification);
        return productos;
    }

    private Specification<Producto> createSpecification(ProductoCriteria criteria) {
        Specification<Producto> specification = Specification.where(null);
        if (criteria == null) {
            return specification;
        }
        if (criteria.getNombre() != null) {
         //  specification = specification.and(this.buildStringSpecification(criteria.getNombre(), Producto_.nombre));
        }
        if (criteria.getDescripcion() != null) {
            //specification =
                   // specification.and(this.buildStringSpecification(criteria.getDescripcion(), Producto_.descripcion));
        }
        if (criteria.getHaveFoto() != null) {
           // specification = specification.and(this.buildSpecification(criteria.getHaveFoto(), Producto_.foto));
        }


        return specification;
    }

    private static ProductoCriteria createCriteria(ProductoBusqueda dto) {
        ProductoCriteria productoCriteria = new ProductoCriteria();
        if (dto != null) {
            if (!StringUtils.isBlank(dto.getNombre())) {
                StringFilter filter = new StringFilter();
                filter.setContains(dto.getNombre());

                productoCriteria.setNombre(filter);
            }
            if (!StringUtils.isBlank(dto.getDescripcion())) {
                StringFilter filter = new StringFilter();

                filter.setContains(dto.getDescripcion());
                productoCriteria.setDescripcion(filter);
            }
            if (BooleanUtils.isTrue(dto.getFotoExist())) {
                StringFilter filter = new StringFilter();
                filter.setNotEquals(null);
                productoCriteria.setHaveFoto(filter);
            }
        }
        return productoCriteria;
    }

    @Override
    public List<Producto> findByStock() {
        return this.rep.findByStock();
    }


    @Override
    public List<Producto> OrderByPricioMax(Double precio) {
        return this.rep.orderByPricioMax(precio);
    }

    @Override
    public List<Producto> OrderByPricioMin(Double precio) {
        return this.rep.orderByPricioMin(precio);
    }

}
