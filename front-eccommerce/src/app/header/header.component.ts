import { Component, OnInit } from '@angular/core';

import { MenuItem } from 'primeng/api';
import {Categoria} from "../entity/categoria";
import {ProductoService} from "../servicios/producto.service";
import {tap} from "rxjs/operators";
import { AuthUsuarioService } from '../servicios/auth-usuario-service';
import { ModalUsuarioService } from '../modal-usuario/modal-usuario.service';


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
  labelBoolean: boolean = false;
  abierto: boolean = false;
  nombre: string = '';

  categorias: Categoria[] = [];
  constructor(private ps: ProductoService,
    private authService: AuthUsuarioService,
    private modalService: ModalUsuarioService) { }

  ngOnInit() {
    this.ps.getCategorias().subscribe(
      response => {
        response.forEach(
          categoria=> {
            this.subitems.push({label: categoria.nombrecategoria, routerLink: ['/productos/', categoria.nombrecategoria]})
          }
        )
        this.categorias = response;
      }

    )

    this.items = [
      {
        label: 'Productos',
        items: [
          { label: 'Todos los productos', routerLink: ['/productos'] },
          {
            label: 'Categorias',
            items: this.subitems
          }
        ],
      },
    ];

    this.itemsButton = [
          {label: 'Información perfil', command: () => {this.abrirModal2()}},
          {label: 'Administrar perfiles', routerLink:['/administrador/lista']},
          {label: 'Cerrar sesión', command: () => {this.authService.logout()}}
    ]

    
    if(this.nombre==''){
      this.authService.getUsuario().subscribe( usuario =>{
        this.nombre=usuario.nombre;
      }
      )
    }
  }

  nombreUsuario(): String{
    return this.nombre;
  }

  isLogged(): boolean{
    return this.authService.isAuthenticated();
  }


  abrirModal2() {
    this.modalService.abrirModal();
    this.abierto = true;
  }

}
