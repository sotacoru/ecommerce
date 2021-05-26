import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PedidosComponent } from './pedidos/pedidos.component';
import { LoginRegisComponent } from './login-regis/login-regis.component';

const routes: Routes = [
  {path: '', redirectTo:'' , pathMatch:'full'},
  {path: 'pedidos', component: PedidosComponent},
  {path: 'login', component: LoginRegisComponent}
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
