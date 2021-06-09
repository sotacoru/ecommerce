import {NgModule} from '@angular/core';
import {ExtraOptions, RouterModule, Routes} from '@angular/router';

import {PedidosComponent} from './pedidos/pedidos.component';
import {LoginRegisComponent} from './login-regis/login-regis.component';
import {ProductosComponent} from './productos/productos.component';
import {ThankyouPageComponent} from './thankyou-page/thankyou-page.component';
import {FormComponent} from './productos/form.component';
import {DetalleProductoComponent} from "./productos/detalle-producto/detalle-producto.component";
import {AdministrarUsuariosComponent} from './administrar-usuarios/administrar-usuarios.component';
import {ProguardService} from "./servicios/proguard.service";
import {ActivatedLoginService} from "./servicios/activatedLogin.service";

const routes: Routes = [
  {path: '', redirectTo: '/productos', pathMatch: 'full'},
  {path: 'login', component: LoginRegisComponent, canActivate: [ActivatedLoginService]},
  {path: 'productos/:categoria', component: ProductosComponent},
  {path: 'productos', component: ProductosComponent},
  {
    path: 'pedido', component: PedidosComponent, canActivate: [ProguardService],
    data: {expectedRol: ['CLIENTE']}
  },

  {
    path: 'producto/:id', component: DetalleProductoComponent, canActivate: [ProguardService],
    data: {expectedRol: ['CLIENTE']}
  },
  {
    path: 'thankyou', component: ThankyouPageComponent, canActivate: [ProguardService],
    data: {expectedRol: ['CLIENTE']}
  },

  {
    path: 'formulario/:id', component: FormComponent, canActivate: [ProguardService],
    data: {expectedRol: ['ADMINISTRADOR', 'SECRETARIO']}
  },
  {
    path: 'formulario', component: FormComponent, canActivate: [ProguardService],
    data: {expectedRol: ['ADMINISTRADOR', 'SECRETARIO']}
  },
  {
    path: 'administrador/lista', component: AdministrarUsuariosComponent, canActivate: [ProguardService],
    data: {expectedRol: ['ADMINISTRADOR']}
  },
  {
    path: 'administrador/actualizar/:idUsuario/:condicion',
    component: LoginRegisComponent,
    canActivate: [ProguardService],
    data: {expectedRol: ['ADMINISTRADOR']}
  },
  {
    path: 'administrador/añadir', component: LoginRegisComponent, canActivate: [ProguardService],
    data: {expectedRol: ['ADMINISTRADOR']}
  },
  {
    path: 'administrador/productos', component: ProductosComponent, canActivate: [ProguardService],
    data: {expectedRol: ['ADMINISTRADOR']}
  }
];
const routerOptions: ExtraOptions = {
  useHash: false,


};


@NgModule({
  imports: [
    RouterModule.forRoot(routes, routerOptions)
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule {
}
