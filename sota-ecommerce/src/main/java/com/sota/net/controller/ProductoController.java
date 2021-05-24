package com.sota.net.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> update( @RequestBody Producto producto, @PathVariable Long id) {
		Producto productoActual = productoService.findById(id);
		Producto productoUpdate = null;
		
		if (productoActual == null) {
		
		}
		productoActual.setNombre(producto.getNombre());
		productoActual.setCantidad(producto.getCantidad());
		productoActual.setDescripcion(producto.getDescripcion());
		productoActual.setIdcategoria(producto.getIdcategoria());
		productoActual.setPrecio(producto.getPrecio());
		productoUpdate = productoService.save(productoActual);
		
		return new ResponseEntity<>(productoUpdate, HttpStatus.CREATED);
		
		
	}
	
	
	
	@GetMapping("/productos")
	public List<Producto> index() {
		return productoService.findAll();
	}

	
	
	
}
