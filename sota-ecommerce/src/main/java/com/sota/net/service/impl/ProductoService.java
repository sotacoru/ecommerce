package com.sota.net.service.impl;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import com.sota.net.entity.Producto_;
//import com.sota.net.entity.Producto_;
import com.sota.net.entity.dto.ProductoBusqueda;
import com.sota.net.repository.IProductoRepository;
import com.sota.net.service.IProductoService;
import com.sota.net.utils.busqueda.ProductoCriteria;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("productoService")
public class ProductoService extends QueryService implements IProductoService {
    @Autowired
    private IProductoRepository rep;

    @Transactional
    @Override
    public List<Producto> findAll() {
        return this.rep.findAll();
    }

    @Transactional
    @Override
    public Optional<Producto> findById(Long id) {

        return this.rep.findById(id);
    }

    @Transactional
    @Override
    public Producto save(Producto producto) {
        return this.rep.save(producto);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.rep.deleteById(id);
    }

    @Transactional
    @Override
    public List<Categoria> findAllCategoria() {
        return this.rep.findAllCategoria();
    }

    @Transactional
    @Override
    public List<Producto> findByCategoria(String categoria) {
        return this.rep.findByCategoria(categoria);
    }


    @Override
    public List<Producto> findWithFilter(ProductoBusqueda dto) {
        //Si el dto está vacio devovlemos una lista vacia
        if (dto.isEmpty()) {
            return Collections.emptyList();
        }
        //Filtramos todos lo productos segun los filtros
        final Specification<Producto> specification = this.createSpecification(ProductoService.createCriteria(dto));
        List<Producto> productos = this.rep.findAll(specification);
        return productos;
    }

    @Override
    public void updateStock(Producto producto, int cantidad) {
        List<Producto> productos = this.rep.findAll();
        for (Producto p: productos){
            if (p.getId().equals(producto.getId())){
                p.setCantidad( p.getCantidad()- cantidad) ;
                this.rep.save(p);
            }
        }
    }
  /**
     * Creamos la specificaciónm a través del producto ya filtrado
     */
    private Specification<Producto> createSpecification(ProductoCriteria criteria) {
        Specification<Producto> specification = Specification.where(null);
        if (criteria == null) {
            return specification;
        }
        if (criteria.getNombre() != null) {
        specification = specification.and(this.buildStringSpecification(criteria.getNombre(), Producto_.nombre));


        }
        if (criteria.getDescripcion() != null) {
          specification = specification.and(this.buildStringSpecification(criteria.getDescripcion(), Producto_.descripcion));
        }
        if (criteria.getHaveFoto() != null) {
          specification = specification.and(this.buildSpecification(criteria.getHaveFoto(), Producto_.foto));
        }


        return specification;
    }
    /**
     * Creamos el Producto con los filtros correspondientes
     */

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
            if (BooleanUtils.isTrue(dto.getFoto())) {
                StringFilter filter = new StringFilter();
                filter.setSpecified(dto.getFoto());
                productoCriteria.setHaveFoto(filter);
            }
        }
        return productoCriteria;
    }




}
