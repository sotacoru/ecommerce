package com.sota.net.controller;
import com.sota.net.entity.Producto;
import com.sota.net.entity.dto.ProductoBusqueda;
import com.sota.net.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    @GetMapping("/producto/stock")
    public List<Producto> getStock(){
        return productoService.findByStock();

    }
    @PostMapping("/producto/busqueda/")
    public ResponseEntity<List<Producto>> busqueda(@RequestBody ProductoBusqueda pb){
        System.out.println(pb.getNombre() + "  "  + pb.getDescripcion());
        if (pb.getNombre()!=null && pb.getDescripcion()==null) {
            //return productoService.findByNombre(nombre);
            System.out.println("Estoy en el primer if");
            return ResponseEntity.ok(productoService.findByNombre(pb.getNombre()));

        }
      if (pb.getNombre()!=null && pb.getDescripcion()==null) {
          return ResponseEntity.ok(productoService.findByDescripcion(pb.getDescripcion()));
      }
        return ResponseEntity.ok( productoService.findByStock());
    }


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
