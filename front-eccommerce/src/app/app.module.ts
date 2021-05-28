import { NgModule } from '@angular/core';
import {FormsModule, NgModel, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { BrowserModule } from '@angular/platform-browser';

import {MenubarModule} from 'primeng/menubar';
import {DataViewModule} from 'primeng/dataview';
import {ButtonModule} from 'primeng/button';
import {PanelModule} from 'primeng/panel';
import {DropdownModule} from 'primeng/dropdown';
import {DialogModule} from 'primeng/dialog';
import {InputTextModule} from 'primeng/inputtext';
import {RatingModule} from 'primeng/rating';
import {RippleModule} from 'primeng/ripple';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PedidosComponent } from './pedidos/pedidos.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { CarritoComponent } from './carrito/carrito.component';
import { VistaPerfilUsuarioComponent } from './vista-perfil-usuario/vista-perfil-usuario.component';

import { LoginRegisComponent } from './login-regis/login-regis.component';
import { ProductosComponent } from './productos/productos.component';
import { FormComponent } from './productos/form.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CheckboxModule} from "primeng/checkbox";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PedidosComponent,
    UsuariosComponent,
    CarritoComponent,
    VistaPerfilUsuarioComponent,
    LoginRegisComponent,
    ProductosComponent,
    FormComponent,


   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenubarModule,
    FormsModule,
    HttpClientModule,
    DataViewModule,
    PanelModule,
    DialogModule,
    DropdownModule,
    InputTextModule,
    ButtonModule,
    RippleModule,
    HttpClientModule,
    RatingModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    CheckboxModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
