import { Component, OnInit } from '@angular/core';

import { MenuItem } from 'primeng/api';
import {Categoria} from "../productos/categoria";
import {ProductoService} from "../servicios/producto.service";
import {tap} from "rxjs/operators";
import { AuthUsuarioService } from '../servicios/auth-usuario-service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  itemsButton: MenuItem[] = [];
  items: MenuItem[] = [];
  subitems: MenuItem[] = [];
  labelBoton: string = 'Log in';
  labelBoolean:boolean = false;

  categorias:Categoria[]= [];
  constructor(private ps: ProductoService,
  private authService: AuthUsuarioService) { }

  ngOnInit(){
    this.ps.getCategorias().subscribe(
      response =>{
        response.forEach(
          categoria=> {
            this.subitems.push({label: categoria.nombrecategoria, routerLink: ['/productos/', categoria.nombrecategoria]})
            console.log(categoria.nombrecategoria)
          }
        )
        this.categorias=response;
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


        ];

    this.itemsButton = [

          {label: 'Información perfil'},
          {label: 'Administrar perfiles', routerLink:['/administrar-usuarios']}

    ];

  }

  isLogged(): boolean{
    if(this.authService.isAuthenticated()){
      return true;
    }
    return false;
  }

  nombreUsuario(): string{
    return this.authService.usuario.nombre;
  }


}
