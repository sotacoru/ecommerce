import {ProductoService} from '../servicios/producto.service';
import {Component, OnInit} from '@angular/core';
import {Producto} from '../entity/producto'
import {PrimeNGConfig, SelectItem} from 'primeng/api';
import {ProductoBusqueda} from "../entity/dto/producto_busqueda";
import {ActivatedRoute} from "@angular/router";
import Swal from "sweetalert2";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {PedidosService} from "../servicios/pedidos.service";
import {AuthUsuarioService} from "../servicios/auth-usuario-service";
import {UsuarioAdapter} from "../adpaters/usuarioAdapter";
import {ProductoAdapter} from "../adpaters/productoAdapter";

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {
  productos: Producto[];
  busqueda: ProductoBusqueda;
  pedido: PedidoDto;
  sortOptions: SelectItem[];
  sortOrder: number;
  sortField: string;
  urlImg: string = "http://localhost:8090/api/uploads/img/"
  imgDefecto: string = "http://localhost:8090/images/notImagen.jpg"
  isAdmin: boolean = false;
  private ua: UsuarioAdapter = new UsuarioAdapter();
  private pa: ProductoAdapter = new ProductoAdapter()

  constructor(private ps: ProductoService,
              private pedidoService: PedidosService,
              private primengConfig: PrimeNGConfig,
              private route: ActivatedRoute,
              private authService: AuthUsuarioService) {
    this.busqueda = new ProductoBusqueda();
  }

  ngOnInit() {
    this.route.params.subscribe(
      params => {
        let categoria: string = params.categoria;
        if (categoria === undefined) {
          this.ps.getProductos().subscribe(
            response => {
              if (!this.isCliente()) {
                this.productos = response
              } else {
                this.productos = response.filter(
                  e => {
                    return e.cantidad > 0
                  }
                )
                console.log(this.productos)
              }
            })
        } else {
          this.ps.getProductosCategoria(categoria).subscribe(
            response => {
              this.productos = response
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

  isCliente(): boolean {
    return !this.authService.isAuthenticated() || this.authService.getPerfil() === 'CLIENTE';

  }

  onSortChange(event) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    } else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }

  buscar() {
    this.ps.getProductosBusqueda(this.busqueda).subscribe(
      response => this.productos = response
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
          response => {
            this.productos = this.productos.filter(pro => pro !== producto)

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
    if (this.pedido) {
      this.pedidoService.setProductosPedido(this.pa.productoPedidoAdapter(producto))

    } else {
      this.pedido = new PedidoDto();
      this.pedido.precioTotal = 0;
      this.pedido.idUsuario = this.ua.usuarioToUsuarioPedido(this.authService.usuario);
      this.pedido.idUsuario.idUsuario = this.authService.getSub()
      this.pedidoService.postPedido(this.pedido)
      this.pedido.precioTotal = producto.precio
      this.pedidoService.setProductosPedido(this.pa.productoPedidoAdapter(producto))
      console.log(this.pedido)

    }
  }


}
