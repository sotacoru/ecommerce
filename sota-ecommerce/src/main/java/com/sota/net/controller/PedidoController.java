package com.sota.net.controller;

import com.sota.net.entity.Pedido;
import com.sota.net.entity.PedidoProducto;
import com.sota.net.entity.dto.PedidoCreadoDto;
import com.sota.net.entity.dto.PedidoDto;
import com.sota.net.entity.dto.PedidoProductoDto;
import com.sota.net.entity.dto.UsuarioDtoConverter;
import com.sota.net.service.IPedidoProductoService;
import com.sota.net.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PedidoController {
	@Autowired
	 private final IPedidoService pedidoService;
	 private final UsuarioDtoConverter usuarioDtoConverter;
	 @Autowired
	 private  final IPedidoProductoService pedidoProductoService;
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
	            response.put("mensaje", "El pedido no existe");
	            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	        }


	        return ResponseEntity.ok(PedidoDto.builder()
					.idUsuario(usuarioDtoConverter.usuarioPedido(pedido.getIdUsuario()))
					.idPago(pedido.getIdPago()).precioTotal(pedido.getPrecioTotal())
					.realizado(pedido.getRealizado())
					.id(pedido.getId())
					.productos(pedido.getPedidoProducto()).build());
	    }
	@PostMapping("/pedido")
	public ResponseEntity<?> crearPedido(@RequestBody PedidoCreadoDto pedidoDto, BindingResult result) {
		Pedido pedidonuevo = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		Pedido pedido = new Pedido();
		pedido.setIdUsuario(pedidoDto.getIdUsuario());
		pedido.setPrecioTotal(pedidoDto.getPrecioTotal());
		pedido.setIdPago(pedidoDto.getIdPago());
		pedido.setPedidoProducto(new ArrayList<>());
		try {
			pedidonuevo = this.pedidoService.save(pedido);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}


		response.put("mensaje", "El pedido ha sido creado con exito!");
		response.put("producto", pedidonuevo);
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}
	@PutMapping("/pedido/{id}")
	public ResponseEntity<?> añadirProducto(@RequestBody List<PedidoProductoDto> productos, @PathVariable long id, BindingResult result) {
		Pedido pedido = this.pedidoService.findById(id);

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		if (pedido == null) {
			response.put("mensaje", "El pedido no existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		List<PedidoProducto> productospedido = new ArrayList<>();
		for (PedidoProductoDto producto: productos) {
			PedidoProducto pedidoProducto = new PedidoProducto();
			pedidoProducto.setPedido(pedido);
			pedidoProducto.setCantidad(producto.getCantidad());
			pedidoProducto.setProducto(producto.getProducto());
			productospedido.add(pedidoProducto);
			pedidoProductoService.save(pedidoProducto);
		}
		pedido.setPedidoProducto(productospedido);
		this.pedidoService.save(pedido);
		response.put("mensaje", "El producto se ha añadido con exito!");

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

}
