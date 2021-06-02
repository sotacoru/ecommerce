import { Component, OnInit } from '@angular/core';

import { Producto } from '../entity/producto';
import { Categoria } from '../entity/categoria';
import { LoginRegisComponent } from '../login-regis/login-regis.component';
import { Usuario } from '../entity/usuario';

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
