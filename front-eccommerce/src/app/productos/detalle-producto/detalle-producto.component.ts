import { Component, OnInit } from '@angular/core';
import {Producto} from "../producto";
import {ProductoService} from "../../servicios/producto.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-detalle-pedido',
  templateUrl: './detalle-producto.component.html',
  styleUrls: ['./detalle-producto.component.scss']
})
export class DetalleProductoComponent implements OnInit {
  producto: Producto;
  constructor(private ps: ProductoService, private activateRoute: ActivatedRoute, private router: Router) {
    this.producto= new Producto();
  }

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      params=>{
        let id:number=params.id
        if (id===undefined){
          this.router.navigate(['/productos'])
        }
        this.ps.getProducto(id).subscribe(
          response=> this.producto = response
        )
      }

    )
  }

}
