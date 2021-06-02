import { Component, OnInit } from '@angular/core';
import {Pedido} from "../entity/pedido";
import {PedidosService} from "../servicios/pedidos.service";
import {PrimeNGConfig, SelectItem} from "primeng/api";
import {Producto} from "../entity/producto";
import {ProductoPedido} from "../entity/dto/productopedido";

@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.scss']
})
export class PedidosComponent implements OnInit {
  pedido: Pedido;
  productos: ProductoPedido[]=[];
  urlImg:string = "http://localhost:8090/api/uploads/img/"
  imgDefecto:string="http://localhost:8090/images/notImagen.jpg"


  constructor(private ps: PedidosService,private primengConfig: PrimeNGConfig) {
    this.pedido= new Pedido();

  }

  ngOnInit(): void {
    this.ps.getPedido(1).subscribe(
      response=>{
        console.log(response)
        this.pedido=response
        this.productos = response.productos
      }
    )
    console.log(this.pedido)

  }

}
