import { Component, OnInit } from '@angular/core';

import { MenuItem } from 'primeng/api';
import {Categoria} from "../productos/categoria";
import {ProductoService} from "../servicios/producto.service";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  items: MenuItem[] = [];
  subitems: MenuItem[] = [];

  categorias:Categoria[]= [];
  constructor(private ps: ProductoService) { }

  ngOnInit(){
    this.ps.getCategorias().subscribe(
      response =>{
        response.forEach(
          categoria=> {
            this.subitems.push({label: categoria.nombrecategoria, routerLink: ['/productos/', categoria.nombrecategoria]})
            console.log(categoria.nombrecategoria)
          }
        )
        this.categorias=response

      }

    )

    this.items = [
            {
                label: 'Productos',
                items: [
                  {label: 'Todos los productos',   routerLink: ['/productos']},
                  {label: 'Categorias',
                  items :  this.subitems
                  }
                ],

            },
            {label: 'Log In', icon: 'pi pi-fw pi-users', routerLink: ['/login']},


        ];

  }


}
