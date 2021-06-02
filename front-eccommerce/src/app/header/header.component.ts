import { Component, OnInit } from '@angular/core';

import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  items: MenuItem[] = [];

  constructor() { }

  ngOnInit(){
    this.items = [
            {
                label: 'Productos',
                items: [
                  {label: 'Categorias'}
                ],
                routerLink: ['/pedidos']
            },
            {label: '', icon: 'pi pi-fw pi-users', routerLink: ['/login']},
            {label: 'Thank You', routerLink: ['/thankyou']},
            {label: 'Productos TEMPORAR', routerLink: ['/productos']},
            {label: 'Configuración',
              items: [
                {label: 'Añadir usuario', icon: 'pi pi-fw pi-user-plus'},
                {label: 'Eliminar usuario', icon: 'pi pi-fw pi-user-minus'},
                {label: 'Editar usuario', icon: 'pi pi-fw pi-user-edit'}
              ]},
            {label: 'infoUser', routerLink: ['/infouser']}
        ];

  }

}
