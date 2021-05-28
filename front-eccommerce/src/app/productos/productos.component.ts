import { ProductoService } from './../servicios/producto.service';
import { Component, OnInit } from '@angular/core';
import{Producto} from './producto'
import { SelectItem } from 'primeng/api';
import { PrimeNGConfig } from 'primeng/api';
import {ProductoBusqueda} from "./producto_busqueda";
import {ActivatedRoute} from "@angular/router";
@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {
  productos: Producto[];
  busqueda: ProductoBusqueda;
  sortOptions: SelectItem[];
  sortOrder: number;
  sortField: string;


  constructor(private ps: ProductoService,  private primengConfig: PrimeNGConfig, private route: ActivatedRoute) {
    this.busqueda= new ProductoBusqueda();
  }

  ngOnInit() {
    this.route.params.subscribe(
      params=>{
          let categoria:string = params.categoria;
          if (categoria===undefined){
            this.ps.getProductos().subscribe(
              response => this.productos=response
            );
          }else{
            this.ps.getProductosCategoria(categoria).subscribe(
              response => {this.productos=response
                this.productos.forEach(producto=>console.log(producto.idcategoria.nombrecategoria))
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
  onSortChange(event) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
        this.sortOrder = -1;
        this.sortField = value.substring(1, value.length);
    }
    else {
        this.sortOrder = 1;
        this.sortField = value;
    }
}

  buscar() {
    this.ps.getProductosBusqueda(this.busqueda).subscribe(
      response => this.productos=response
    );
      console.log(this.busqueda.nombre + ' ' + this.busqueda.foto)
  }


}
