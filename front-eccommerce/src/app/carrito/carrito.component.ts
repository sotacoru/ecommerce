import { Component, OnInit } from '@angular/core';
import { Producto } from '../productos/producto';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.scss']
})
export class CarritoComponent implements OnInit {
  productos: Producto[];
  constructor() { }

  ngOnInit(): void {
  }

}
