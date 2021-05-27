package com.sota.net.repository;

import com.sota.net.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("select p from Pedido p inner  join PedidoProducto pp on p.id = pp.pedido.id where p.id= ?1 ")
    abstract Pedido getPedidoById(Long id);
}
