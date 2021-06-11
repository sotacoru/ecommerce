import {Component, OnInit} from '@angular/core';
import {Producto} from "../../entity/producto";
import {ProductoService} from "../../servicios/producto.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PedidosService} from "../../servicios/pedidos.service";
import {PedidoDto} from "../../entity/dto/pedidoDto";
import {UsuarioAdapter} from "../../adpaters/usuarioAdapter";
import {ProductoAdapter} from "../../adpaters/productoAdapter";
import {AuthUsuarioService} from "../../servicios/auth-usuario-service";
import {PedidoAdapter} from "../../adpaters/pedidoAdapter";

@Component({
  selector: 'app-detalle-pedido',
  templateUrl: './detalle-producto.component.html',
  styleUrls: ['./detalle-producto.component.scss']
})
export class DetalleProductoComponent implements OnInit {
  producto: Producto;
  urlImg: string = "http://localhost:8090/api/uploads/img/";
  imgDefecto: string = "http://localhost:8090/images/notImagen.jpg"
  pedido: PedidoDto;
  private ua: UsuarioAdapter = new UsuarioAdapter();
  private pa: ProductoAdapter = new ProductoAdapter()
  private pedidoAdapter: PedidoAdapter = new PedidoAdapter();

  constructor(private ps: ProductoService, private activateRoute: ActivatedRoute,
              private authService: AuthUsuarioService, private router: Router, private pedidoService: PedidosService,) {
    this.producto = new Producto();
  }

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      params => {
        let id: number = params.id
        if (id === undefined) {
          this.router.navigate(['/productos'])
        }
        this.ps.getProducto(id).subscribe(
          response => this.producto = response
        )
      }
    )
    this.pedidoService.getPedido().subscribe(
      p => {
        this.pedido = this.pedidoAdapter.pedidoAdapter(p)
      }
    )
  }


  addProductoCarrito(producto: Producto) {
    if (this.pedido !== undefined) {
      this.pedidoService.setProductosPedido(this.pa.productoPedidoAdapter(producto))

    } else {
      this.pedido = new PedidoDto();
      this.pedido.precioTotal = 0;
      if (this.authService.isAuthenticated()) {
        this.pedido.idUsuario = this.ua.usuarioToUsuarioPedido(this.authService.usuario);
      } else {
        this.pedido.idUsuario = null;
      }
      this.pedidoService.postPedido(this.pedido)
      this.pedido.precioTotal = producto.precio
      this.pedidoService.setProductosPedido(this.pa.productoPedidoAdapter(producto))


    }
  }
}
