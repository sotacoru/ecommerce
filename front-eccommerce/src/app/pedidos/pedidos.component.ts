import {Component, OnDestroy, OnInit} from '@angular/core';
import {Pedido} from "../entity/pedido";
import {PedidosService} from "../servicios/pedidos.service";
import {ProductoPedido} from "../entity/dto/productopedido";
import {Subscription} from "rxjs";
import {AuthUsuarioService} from "../servicios/auth-usuario-service";
import {Pago} from "../entity/pago";
import {MenuItem} from "primeng/api";
import Swal from "sweetalert2";
import {Router} from "@angular/router";
import {UsuarioAdapter} from "../adpaters/usuarioAdapter";
import {PedidoAdapter} from "../adpaters/pedidoAdapter";
import {ProductoPedidoDto} from "../entity/dto/productopedidodto";

@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.scss']
})
export class PedidosComponent implements OnInit, OnDestroy {
  pedido: Pedido;
  productos: ProductoPedido[] = [];
  urlImg: string = "http://localhost:8090/api/uploads/img/"
  imgDefecto: string = "http://localhost:8090/images/notImagen.jpg"
  sus: Subscription
  metodosdePago: Pago[]
  itemsPago: MenuItem[] = [];
  ua: UsuarioAdapter = new UsuarioAdapter();
  pa: PedidoAdapter = new PedidoAdapter();

  constructor(private ps: PedidosService, private as: AuthUsuarioService, private route: Router) {
    this.pedido = new Pedido();

  }

  ngOnInit(): void {
    this.sus = this.ps.getPedido().subscribe(
      response => {
        this.pedido = response
      }
    )
    this.ps.getProductosPedido().subscribe(
      res => this.productos = res
    );
    this.ps.getPagos().subscribe(
      r => {
        r.forEach(
          p => {
            this.itemsPago.push({
              label: p.tipopago, command: () => {
                this.pedido.idPago = p
                this.pedido.realizado = 1;
                this.confirmarPedido()
              }, routerLink: ['/thankyou']
            })
          }
        )
        this.metodosdePago = r;
      }
    )
    if (this.as.isAuthenticated()) {
      this.pedido.idUsuario = this.ua.usuarioToUsuarioPedido(this.as.usuario);
    } else {
      this.pedido.idUsuario = null;
    }


    this.pedido.precioTotal = this.calcularTotal();


  }

  ngOnDestroy() {
    this.sus.unsubscribe()
  }

  calcularTotal(): number {
    return this.ps.getTotalPedido()
  }


  confirmarPedido() {


    this.ps.confirmarPedido(this.pa.pedidoAdapter(this.pedido), this.pedido.id).subscribe(
      response => {
        Swal.fire(
          'Realizado',
          `El pedido se ha realizado con exito`,
          'success',
        )


      }
    )


  }


  isLogged(): boolean {
    if (this.as.isAuthenticated()) {
      return true;
    }
    return false;
  }


  eliminarProducto(p: ProductoPedidoDto) {
    this.ps.deleteProductoCarrito(p);
  }

  restarCantidad(p: ProductoPedido) {
    this.ps.restarCantidadProducto(p)
  }

  sumarCantidad(p: ProductoPedido) {
    this.ps.sumarCantidadProducto(p)
  }
}
