import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {MenubarModule} from 'primeng/menubar';
import {DataViewModule} from 'primeng/dataview';
import {ButtonModule} from 'primeng/button';
import {PanelModule} from 'primeng/panel';
import {DropdownModule} from 'primeng/dropdown';
import {DialogModule} from 'primeng/dialog';
import {InputTextModule} from 'primeng/inputtext';
import {RatingModule} from 'primeng/rating';
import {RippleModule} from 'primeng/ripple';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {PedidosComponent} from './pedidos/pedidos.component';
import {UsuariosComponent} from './usuarios/usuarios.component';
import {VistaPerfilUsuarioComponent} from './vista-perfil-usuario/vista-perfil-usuario.component';
import {LoginRegisComponent} from './login-regis/login-regis.component';
import {ProductosComponent} from './productos/productos.component';
import {FormComponent} from './productos/form.component';
import {ModalUsuarioService} from './modal-usuario/modal-usuario.service';
import {ThankyouPageComponent} from './thankyou-page/thankyou-page.component';
import {TokenInterceptor} from './usuarios/interceptor/tokenInterceptor';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CheckboxModule} from "primeng/checkbox";

import {CommonModule} from '@angular/common';

import {DetalleProductoComponent} from "./productos/detalle-producto/detalle-producto.component";
import {SplitButtonModule} from 'primeng/splitbutton';
import {ModalUsuarioComponent} from './modal-usuario/modal-usuario.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PedidosComponent,
    UsuariosComponent,
    VistaPerfilUsuarioComponent,
    LoginRegisComponent,
    ProductosComponent,
    FormComponent,
    ThankyouPageComponent,
    DetalleProductoComponent,
    ModalUsuarioComponent,

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
    CommonModule,
    SplitButtonModule
  ],
  bootstrap: [AppComponent],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    ModalUsuarioService
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]

})
export class AppModule {
}
