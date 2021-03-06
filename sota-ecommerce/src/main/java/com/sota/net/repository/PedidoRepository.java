package com.sota.net.repository;

import com.sota.net.entity.Pago;
import com.sota.net.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("select p from  PedidoProducto p where p.producto.id = ?1 ")
    abstract Pedido getPedidoById(Long id);
    @Query("from Pago")
    abstract List<Pago> getAllPagos();

}
