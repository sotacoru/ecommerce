import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {MenubarModule} from 'primeng/menubar';
import {MenuItem} from 'primeng/api';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PedidosComponent } from './pedidos/pedidos.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { FormLoginRegistroComponent } from './form-login-registro/form-login-registro.component';
import { CarritoComponent } from './carrito/carrito.component';
import { VistaPerfilUsuarioComponent } from './vista-perfil-usuario/vista-perfil-usuario.component';
import { ProductosComponent } from './productos/productos.component';
import { FormComponent } from './productos/form.component';



@NgModule({
  declarations: [	
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PedidosComponent,
    UsuariosComponent,
    FormLoginRegistroComponent,
    CarritoComponent,
    VistaPerfilUsuarioComponent,
      ProductosComponent,
      FormComponent,
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenubarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
