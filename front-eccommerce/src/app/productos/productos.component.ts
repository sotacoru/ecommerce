import { ProductoService } from '../servicios/producto.service';
import { Component, OnInit } from '@angular/core';
import{Producto} from '../entity/producto'
import { SelectItem } from 'primeng/api';
import { PrimeNGConfig } from 'primeng/api';
import {ProductoBusqueda} from "../entity/dto/producto_busqueda";
import {ActivatedRoute} from "@angular/router";
import Swal from "sweetalert2";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {PedidosService} from "../servicios/pedidos.service";
import {UsuarioPedidoDto} from "../entity/dto/usuarioPedidoDto";
import {Usuario} from "../entity/usuario";
import {AuthUsuarioService} from "../servicios/auth-usuario-service";
import {ProductoPedido} from "../entity/dto/productopedido";
import {Pedido} from "../entity/pedido";
@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {
  productos: Producto[];
  busqueda: ProductoBusqueda;
  pedido:PedidoDto;
  sortOptions: SelectItem[];
  sortOrder: number;
  sortField: string;
  urlImg:string = "http://localhost:8090/api/uploads/img/"
  imgDefecto:string="http://localhost:8090/images/notImagen.jpg"
  isAdmin: boolean = false;
  constructor(private ps: ProductoService, private pedidoService: PedidosService,
              private primengConfig: PrimeNGConfig, private route: ActivatedRoute,
              private as: AuthUsuarioService) {
    this.busqueda= new ProductoBusqueda();
  }

  ngOnInit() {
    this.route.params.subscribe(
      params=>{
          let categoria:string = params.categoria;
          if (categoria===undefined){
            this.ps.getProductos().subscribe(
              response => this.productos=response
            );
          }else{
            this.ps.getProductosCategoria(categoria).subscribe(
              response => {this.productos=response
                this.productos.forEach(producto=>console.log(producto.idcategoria.nombrecategoria))
              }
            )
          }
      })

     this.sortOptions = [
      {label: 'Más caros primero', value: '!precio'},
      {label: 'Más baratos primero', value: 'precio'}
    ];
    this.primengConfig.ripple = true;
  }
  onSortChange(event) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
        this.sortOrder = -1;
        this.sortField = value.substring(1, value.length);
    }
    else {
        this.sortOrder = 1;
        this.sortField = value;
    }
}

  buscar() {
    this.ps.getProductosBusqueda(this.busqueda).subscribe(
      response => this.productos=response
    );
  }


  eliminar(producto: Producto) {
    Swal.fire({
      title: 'Está seguro',
      text: `¿Seguro que desea eliminar el producto?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.ps.delete(producto.id).subscribe(
          response =>{
            this.productos = this.productos.filter(pro=> pro !== producto)

            Swal.fire(
              'borrado',
              `El producto se ha eliminado`,
              'success'
            )
          }
        )

      }
    })

  }

  addProductoCarrito(producto: Producto) {


    if (this.pedido != undefined){
      this.pedidoService.setProductosPedido(this.productoPedidoAdapter(producto))
      }else{
        this.pedido = new PedidoDto();
        this.pedido.precioTotal=0;
        this.pedido.idUsuario =this.usuarioPedidoAdapter(this.as.usuario);
        this.pedidoService.postPedido(this.pedido).subscribe(
          response=> this.pedido=response
        );
        this.pedidoService.setProductosPedido(this.productoPedidoAdapter(producto))
        console.log("añadiendo producto a carrito")
      }
  }
  usuarioPedidoAdapter(u:Usuario): UsuarioPedidoDto{
    let up: UsuarioPedidoDto = new UsuarioPedidoDto();
    up.id = u.idUsuario;
    up.email= u.email;
    up.nombre= u.nombre;
    up.primerApellido= u.primerapellido;
    up.segundoApellido = u.segundoapellido;
    return up;
  }
  productoPedidoAdapter(p:Producto): ProductoPedido {
    let pp:ProductoPedido = new ProductoPedido();
    pp.producto=p;
    pp.cantidad =pp.cantidad+1;
    return pp;
  }
}
