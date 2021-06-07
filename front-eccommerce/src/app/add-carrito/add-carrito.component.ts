import {Component, Input, OnInit} from '@angular/core';
import {Producto} from "../entity/producto";
import Swal from "sweetalert2";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {UsuarioAdapter} from "../adpaters/usuarioAdapter";
import {ProductoAdapter} from "../adpaters/productoAdapter";
import {Pedido} from "../entity/pedido";
import {ProductoService} from "../servicios/producto.service";
import {PedidosService} from "../servicios/pedidos.service";
import {AuthUsuarioService} from "../servicios/auth-usuario-service";

@Component({
  selector: 'app-add-carrito',
  templateUrl: './add-carrito.component.html',
  styleUrls: ['./add-carrito.component.scss']
})
export class AddCarritoComponent implements OnInit {
  private ua: UsuarioAdapter = new UsuarioAdapter();
  private pa: ProductoAdapter = new ProductoAdapter()
  private pedido: Pedido
  @Input() producto: Producto

  constructor(private ps: ProductoService,
              private pedidoService: PedidosService,
              private authService: AuthUsuarioService,) {
  }

  ngOnInit(): void {
  }

  perfil(): any {

    let user = JSON.parse(window.sessionStorage.getItem("usuario"));
    if (user) {
      return user.rol
    }
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
