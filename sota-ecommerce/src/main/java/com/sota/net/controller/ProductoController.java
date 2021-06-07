package com.sota.net.controller;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.Producto;
import com.sota.net.entity.dto.ProductoBusqueda;
import com.sota.net.service.IFotoService;
import com.sota.net.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    @Autowired
    private IFotoService fotoService;

    //Parte pública
    @GetMapping("/producto/stock")
    public List<Producto> getStock() {
        return this.productoService.findByStock();

    }
    
    @GetMapping("/producto/all")
    public List<Producto> getAllProducts() {
        return this.productoService.findAll();

    }

    //Parte pública
    @PostMapping("/producto/busqueda")
    public ResponseEntity<?> busqueda(@RequestBody ProductoBusqueda pb, BindingResult bindingResult) {

        Map<String, Object> response = new HashMap<>();

        if (ProductoController.comporbarBindingResult(bindingResult, response))
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(this.productoService.findWithFilter(pb));
    }

    //Parte pública
    @GetMapping("/producto/{id}")
    public ResponseEntity<Object> show(@PathVariable Long id) {
        Producto producto = null;
        Map<String, Object> response = new HashMap<>();
        try {
            producto = this.productoService.findById(id);
        } catch (DataAccessException e) {
            response.put("error", "No se ha podido acceder al recurso");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (producto == null) {
            response.put("mensaje", "El producto no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(producto);
    }

    //parte pública
    @GetMapping("/producto/categoria/{categoria}")
    public ResponseEntity<Object> showByCategoria(@PathVariable String categoria) {

        Map<String, Object> response = new HashMap<>();

        if (categoria == null) {
            response.put("mensaje", "La categoria no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(this.productoService.findByCategoria(categoria));
    }

    @GetMapping("/administracion/producto")
    public List<Producto> index() {
        return this.productoService.findAll();
    }

    @PostMapping("/administracion/producto")
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto, BindingResult result) {
        Producto newProducto = null;

        Map<String, Object> response = new HashMap<>();

        if (ProductoController.comporbarBindingResult(result, response))
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        try {
            newProducto = this.productoService.save(producto);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "El producto ha sido creado con exito!");
        response.put("producto", newProducto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping("/administracion/producto/{id}")
    public ResponseEntity<?> update(@RequestBody Producto producto, BindingResult result, @PathVariable Long id) {

        Producto productoActual = this.productoService.findById(id);
        Map<String, Object> response = new HashMap<>();

        Producto productoUpdate = null;

        if (ProductoController.comporbarBindingResult(result, response))
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        if (productoActual == null) {
            response.put("mensaje", "Error, no se puede editar, el cliente con el ID:"
                    .concat(id.toString().concat(" no existe en la bbdd")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {
            productoActual.setNombre(producto.getNombre());
            productoActual.setCantidad(producto.getCantidad());
            productoActual.setDescripcion(producto.getDescripcion());
            productoActual.setIdcategoria(producto.getIdcategoria());
            productoActual.setPrecio(producto.getPrecio());
            productoUpdate = this.productoService.save(productoActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la actualizacion");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido creado con exito!");
        response.put("producto", productoUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    private static boolean comporbarBindingResult(BindingResult result, Map<String, Object> response) {
        if (!result.hasErrors()) {
            return false;
        }
        List<String> errors = result.getFieldErrors().stream()
                .map(err -> "El campo:'" + err.getField() + "' " + err.getDefaultMessage())
                .collect(Collectors.toList());
        response.put("errors", errors);
        return true;
    }

    @DeleteMapping("/administracion/producto/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Producto productoBorrar = this.productoService.findById(id);
        if (productoBorrar == null) {
            response.put("mensaje", "El producto que intenta eliminar no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            String foto = productoBorrar.getFoto();
            if (foto != null && foto.length() > 0) {
                Path rant = Paths.get("uploads").resolve(foto).toAbsolutePath();
                Files.delete(rant);

            }

            this.productoService.delete(id);
        } catch (DataAccessException | IOException e) {
            response.put("error", "No se hay podido eliminar el producto");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El producto ha sido eliminado con exito");
        return ResponseEntity.ok(response);

    }


    @PostMapping("/administracion/productos/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Producto producto = this.productoService.findById(id);

        if (!archivo.isEmpty()) {
            String nombreArchivo = null;
            try {
                nombreArchivo = this.fotoService.copiar(archivo);
            } catch (IOException e) {
                response.put("mensaje", "Error al subir el archivo los datos");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            String nombreFotoAntiguo = producto.getFoto();
            
            
            this.fotoService.eliminar(nombreFotoAntiguo);

            producto.setFoto(nombreArchivo);
            this.productoService.save(producto);

            response.put("producto", producto);
            response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {
        Resource recurso = null;

        try {
            recurso = this.fotoService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<>(recurso, cabecera, HttpStatus.OK);
    }

    //Parte publicas
    @GetMapping("/producto/categorias")
    public List<Categoria> listarCategorias() {
        return this.productoService.findAllCategoria();
    }


}
