package com.sota.net.controller;

import com.sota.net.adapters.PedidoAdapter;
import com.sota.net.adapters.PedidoProductoAdapter;
import com.sota.net.entity.Pago;
import com.sota.net.entity.Pedido;
import com.sota.net.entity.PedidoProducto;
import com.sota.net.entity.Usuario;
import com.sota.net.entity.dto.PedidoCreadoDto;
import com.sota.net.entity.dto.PedidoDto;
import com.sota.net.entity.dto.UsuarioDtoConverter;
import com.sota.net.service.IPedidoProductoService;
import com.sota.net.service.IPedidoService;
import com.sota.net.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PedidoController {

	 private final IPedidoService pedidoService;
	 private final UsuarioDtoConverter usuarioDtoConverter;
	 private  final IPedidoProductoService pedidoProductoService;
	 private final IProductoService productoService;

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

			if (pedido.getIdUsuario()!=null){
				return ResponseEntity.ok(PedidoDto.builder()
						.idUsuario(usuarioDtoConverter.usuarioPedido(pedido.getIdUsuario()))
						.idPago(pedido.getIdPago()).precioTotal(pedido.getPrecioTotal())
						.realizado(pedido.getRealizado())
						.id(pedido.getId())
						.productos(PedidoProductoAdapter.adapterPedidoProductoDtoLista(pedido.getPedidoProducto())).build());
			}
				 return ResponseEntity.ok(PedidoDto.builder()
						 .idPago(pedido.getIdPago()).precioTotal(pedido.getPrecioTotal())
						 .realizado(pedido.getRealizado())
						 .id(pedido.getId())
						 .productos(PedidoProductoAdapter.adapterPedidoProductoDtoLista(pedido.getPedidoProducto())).build());
	 }
	@PostMapping("/pedido")
	public ResponseEntity<?> crearPedido(@RequestBody PedidoCreadoDto pedidoDto, BindingResult result) {
		Pedido pedidonuevo = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		Usuario usuarioPedido = null;
		if (pedidoDto.getIdUsuario()!=null){
			usuarioPedido = usuarioDtoConverter.usuarioPedidoToUsuario(pedidoDto.getIdUsuario());
		}

		Pedido pedido = PedidoAdapter.getPedido(pedidoDto, usuarioPedido);
		try {
			pedidonuevo = this.pedidoService.save(pedido);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}


		response.put("mensaje", "El pedido ha sido creado con exito!");
		response.put("pedido", pedidonuevo);
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}


	@PutMapping("/pedido/{id}")
	public ResponseEntity<?> actualizarPedido(@RequestBody PedidoDto pedidoDto, @PathVariable long id, BindingResult result) {
		Pedido pedidoActual = this.pedidoService.findById(id);

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		if (pedidoActual == null) {
			response.put("mensaje", "El pedido no existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		pedidoActual.setPrecioTotal(pedidoDto.getPrecioTotal());
		pedidoActual.setIdPago(pedidoDto.getIdPago());
		pedidoActual.setIdUsuario(this.usuarioDtoConverter.usuarioPedidoToUsuario(pedidoDto.getIdUsuario()));
		pedidoActual.setRealizado(pedidoDto.getRealizado());

		pedidoActual.setPedidoProducto(PedidoProductoAdapter.adapterPedidoProductoLista(pedidoDto.getProductos()));

		for (PedidoProducto pp: pedidoActual.getPedidoProducto() ){
			pp.setPedido(pedidoActual);
			this.pedidoProductoService.save(pp);
			this.productoService.updateStock(pp.getProducto(), pp.getCantidad());

		}
		this.pedidoService.save(pedidoActual);
		response.put("mensaje", "El pedido se ha modificado con exito!");

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}


	@GetMapping("/pedido/pagos")
	public List<Pago> listarCategorias() {
		return this.pedidoService.findAllPagos();
	}




}
