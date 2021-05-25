package com.sota.net.utils.generic;

import com.sota.net.entity.Producto;
import com.sota.net.entity.dto.ProductoBusqueda;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class GenericSpecification <T> implements Specification<T> {
    private List<SearchCriteria> list;
    public GenericSpecification() {
        this.list = new ArrayList<>();
    }
    public void add(ProductoBusqueda busqueda) {
        list.add(busqueda);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        //create a new predicate list
        List<Predicate> predicates = new ArrayList<>();

        //add add criteria to predicates
        for (SearchCriteria searchCriteria : list) {
            if (!searchCriteria.getFotoExist().booleanValue() && busqueda.getNombre()==null) {
                predicates.add(builder.like(root.get(),
                        "%"+busqueda.getDescripcion().toUpperCase()+"%");
            }

            if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(builder.greaterThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
    }
}
