package com.sota.net.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sota.net.entity.Producto;
import com.sota.net.service.IProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	
	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/producto")
	public ResponseEntity<?> crearProducto(@RequestBody Producto producto){
		Producto newProducto = productoService.save(producto);
		return new ResponseEntity<>(newProducto, HttpStatus.CREATED) ;
		
	}
	
	@GetMapping("/clientes")
	public List<Producto> index() {
		return productoService.findAll();
	}

	
	
	
}
