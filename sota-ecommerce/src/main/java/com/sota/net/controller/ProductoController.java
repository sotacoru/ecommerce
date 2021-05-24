package com.sota.net.controller;

import com.sota.net.entity.Producto;
import com.sota.net.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private IProductoService ser;
    @GetMapping("/productos")
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
    @GetMapping("/productos/busqueda/{nombre}/{descripcion}")
    public List<Producto> busqueda(@PathVariable String nombre, @PathVariable  String descripcion){
        if (descripcion==null && nombre!=null )
            return ser.findByNombre(nombre);

        return  ser.findByDescripcion(descripcion);




    }

}
