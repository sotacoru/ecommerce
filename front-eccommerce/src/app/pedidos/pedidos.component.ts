import { Component, OnInit } from '@angular/core';
import {Pedido} from "./pedido";
import {PedidosService} from "../servicios/pedidos.service";

@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.scss']
})
export class PedidosComponent implements OnInit {
  pedido: Pedido;
  constructor(private ps: PedidosService) {
    this.pedido= new Pedido();
  }

  ngOnInit(): void {
    this.ps.getPedido(1).subscribe(
      response=> this.pedido=response
    )
    console.log(this.pedido)
  }

}
