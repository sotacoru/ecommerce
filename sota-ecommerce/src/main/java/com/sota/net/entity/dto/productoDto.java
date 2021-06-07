package com.sota.net.entity.dto;

import java.util.List;

import com.sota.net.entity.Categoria;
import com.sota.net.entity.PedidoProducto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class productoDto {

	private Long id;
	private String nombre;
	private Double precio;
	private String descripcion;
    private int cantidad;
    private String foto;
    private List<PedidoProducto> pedidoProducto;
    private Categoria idcategoria;

    
}
