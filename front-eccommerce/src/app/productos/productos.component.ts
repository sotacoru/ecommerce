import { ProductoService } from './../servicios/producto.service';
import { Component, OnInit } from '@angular/core';
import{Producto} from './productos'
import { SelectItem } from 'primeng/api';
@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {
  productos: Producto[];
  sortOptions: SelectItem[];


  sortOrder: number;

  sortField: string;

  constructor(private ps: ProductoService) {
  }

  ngOnInit() {
    this.ps.getProductos().subscribe(
      response => this.productos=response

     );
     this.sortOptions = [
      {label: 'Precio de más alto a bajo', value: '!precio'},
      {label: 'Precio de más bajo a alto', value: 'precio'}
  ];

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

}
