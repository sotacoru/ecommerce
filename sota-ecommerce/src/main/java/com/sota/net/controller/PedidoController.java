package com.sota.net.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sota.net.entity.Pedido;
import com.sota.net.service.IPedidoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PedidoController {
	
	 @Autowired
	 private IPedidoService pedidoService;
	 
	 @GetMapping("/pedido/{id}")
	    public ResponseEntity<Object> mostrarPedido(@PathVariable Long id) {
	        Pedido pedido = null;
	        Map<String, Object> response = new HashMap<>();
	        try {
	        	pedido = this.pedidoService.findById(id);
	        } catch (DataAccessException e) {
	            response.put("error", "No se ha podido acceder al recurso");
	            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        if (pedido == null) {
	            response.put("mensaje", "El producto no existe");
	            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	        }

	        return ResponseEntity.ok(pedido);
	    }

}
