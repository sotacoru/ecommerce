import {Component, OnDestroy, OnInit} from '@angular/core';
import {Pedido} from "../entity/pedido";
import {PedidosService} from "../servicios/pedidos.service";
import {ProductoPedido} from "../entity/dto/productopedido";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {Subscription} from "rxjs";

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

  constructor(private ps: PedidosService) {
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

  pedidoAdapter(): PedidoDto {
    let p: PedidoDto = new PedidoDto();
    p.id = this.pedido.id;
    p.precioTotal = this.pedido.precioTotal;
    p.idUsuario = this.pedido.idUsuario;
    p.idPago = this.pedido.idPago;

    return p;
  }

  confirmarPedido() {
    this.ps.actualizarPedido(this.pedidoAdapter(), this.pedido.id).subscribe(
      r => {
        console.log(r)
      }
    )
    this.ps.confirmarPedido(this.pedido.id).subscribe(
      r => {
        console.log(r)
      }
    )
  }
}
