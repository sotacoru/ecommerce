import { ProductoService } from './../servicios/producto.service';
import { Component, OnInit } from '@angular/core';
import{Producto} from './productos'
import { SelectItem } from 'primeng/api';
import { PrimeNGConfig } from 'primeng/api';
import {ProductoBusqueda} from "./producto_busqueda";
@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {
  productos: Producto[];
  busqueda: ProductoBusqueda = new ProductoBusqueda();
  sortOptions: SelectItem[];
  sortOrder: number;
  sortField: string;


  constructor(private ps: ProductoService,  private primengConfig: PrimeNGConfig) {
  }

  ngOnInit() {
    this.ps.getProductos().subscribe(
      response => this.productos=response
     );
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
