package com.sota.net.controller;

import com.sota.net.entity.Producto;
import com.sota.net.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private IProductoService ser;
    @GetMapping("/producto")
    public List<Producto> getStock(){
/*
        if (nombre!=null & descripcion==null){
         return ser.findByNombre(nombre);
        }
        if (nombre==null & descripcion!=null){
            return ser.findByDescripcion(descripcion);
        }*/
        return ser.findByStock();

    }
    @GetMapping("/producto/busqueda/{nombre}/{descripcion}")
    public List<Producto> busqueda(@PathVariable String nombre, @PathVariable  String descripcion){
        if (descripcion==null && nombre!=null )
            return ser.findByNombre(nombre);

        return  ser.findByDescripcion(descripcion);




    }

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
