import {Component, OnInit} from '@angular/core';
import {Pedido} from "../entity/pedido";
import {PedidosService} from "../servicios/pedidos.service";
import {PrimeNGConfig} from "primeng/api";
import {ProductoPedido} from "../entity/dto/productopedido";

@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.scss']
})
export class PedidosComponent implements OnInit {
  pedido: Pedido;
  productos: ProductoPedido[] = [];
  urlImg: string = "http://localhost:8090/api/uploads/img/"
  imgDefecto: string = "http://localhost:8090/images/notImagen.jpg"


  constructor(private ps: PedidosService, private primengConfig: PrimeNGConfig) {
    this.pedido = new Pedido();

  }

  ngOnInit(): void {

    this.productos = this.ps.getProductosPedido();


    this.pedido.precioTotal = this.calcularTotal();
    console.log(this.pedido)

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

  confirmarPedido() {

  }
}
