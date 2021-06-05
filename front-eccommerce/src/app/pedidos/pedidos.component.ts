import {Component, OnDestroy, OnInit} from '@angular/core';
import {Pedido} from "../entity/pedido";
import {PedidosService} from "../servicios/pedidos.service";
import {ProductoPedido} from "../entity/dto/productopedido";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {Subscription} from "rxjs";
import {AuthUsuarioService} from "../servicios/auth-usuario-service";
import {UsuarioPedidoDto} from "../entity/dto/usuarioPedidoDto";
import {Usuario} from "../entity/usuario";
import {Pago} from "../entity/pago";
import {MenuItem} from "primeng/api";

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

  constructor(private ps: PedidosService, private as: AuthUsuarioService) {
    this.pedido = new Pedido();

  }

  ngOnInit(): void {
    this.sus = this.ps.getPedido().subscribe(
      response => {
        this.pedido = response
        console.log(response)
      }
    )
    this.productos = this.ps.getProductosPedido();
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
    if (this.as.usuario) {
      this.pedido.idUsuario = this.usuarioAdapter(this.as.usuario)
    } else {
      this.pedido.idUsuario = null
    }


    this.pedido.precioTotal = this.calcularTotal();


  }

  ngOnDestroy() {
    this.sus.unsubscribe()
  }

  calcularTotal(): number {
    let total: number = 0
    this.productos.forEach(
      values => {
        total = total + (values.cantidad * values.producto.precio)
      }
    )
    return total;
  }

  usuarioAdapter(u: Usuario): UsuarioPedidoDto {
    let usuarioDto: UsuarioPedidoDto = new UsuarioPedidoDto();
    usuarioDto.idUsuario = u.idUsuario;
    usuarioDto.nombre = u.nombre;
    usuarioDto.email = u.email;
    usuarioDto.primerApellido = u.primerapellido;
    usuarioDto.segundoApellido = u.segundoapellido;
    return usuarioDto;
  }

  pedidoAdapter(): PedidoDto {
    let p: PedidoDto = new PedidoDto();
    p.id = this.pedido.idUsuario.idUsuario = this.as.getSub();
    p.realizado = this.pedido.realizado
    p.precioTotal = this.pedido.precioTotal;
    p.idUsuario = this.pedido.idUsuario;
    p.idPago = this.pedido.idPago;
    return p;
  }

  confirmarPedido() {
    this.ps.confirmarPedido(this.pedidoAdapter(), this.pedido.id).subscribe(

    )
  }

  isLogged(): boolean {
    if (this.as.isAuthenticated()) {
      return true;
    }
    return false;
  }


}
