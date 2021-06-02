import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PedidosComponent } from './pedidos/pedidos.component';
import { LoginRegisComponent } from './login-regis/login-regis.component';
import { ProductosComponent } from './productos/productos.component';
import { ThankyouPageComponent } from './thankyou-page/thankyou-page.component';
import { FormComponent } from './productos/form.component';
import {DetalleComponent} from "./modal-perfil-user/detalle.component";
import {DetalleProductoComponent} from "./productos/detalle-producto/detalle-producto.component";
import { CarritoComponent } from './carrito/carrito.component';
import {AdministrarUsuariosComponent } from './administrar-usuarios/administrar-usuarios.component';

const routes: Routes = [
  {path: '', redirectTo:'/productos' , pathMatch:'full'},
  {path: 'pedidos', component: PedidosComponent},
  {path: 'login', component: LoginRegisComponent},
  {path: 'productos/:categoria', component: ProductosComponent},
  {path:'producto/:id', component:DetalleProductoComponent },
  {path: 'thankyou', component: ThankyouPageComponent},
  {path: 'productos', component: ProductosComponent},
  {path: 'formulario/:id', component: FormComponent},
  {path: 'formulario', component: FormComponent},
  {path: 'carrito', component: CarritoComponent},
  {path: 'administrar-usuarios', component:AdministrarUsuariosComponent}
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
