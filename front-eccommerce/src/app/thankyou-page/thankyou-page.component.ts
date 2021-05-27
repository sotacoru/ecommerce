import { Component, OnInit } from '@angular/core';

import { Producto } from '../productos/producto';
import { Categoria } from '../productos/categoria';
import { LoginRegisComponent } from '../login-regis/login-regis.component';
import { Usuario } from '../usuarios/usuario';

@Component({
  selector: 'app-thankyou-page',
  templateUrl: './thankyou-page.component.html',
  styleUrls: ['./thankyou-page.component.scss']
})
export class ThankyouPageComponent implements OnInit {

  usuario: Usuario;

  constructor() { }

  ngOnInit(){
  }

}
