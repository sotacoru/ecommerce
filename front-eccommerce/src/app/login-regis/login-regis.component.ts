import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Perfil } from '../entity/perfil';
import { PerfilService} from '../usuarios/perfil.service';
import { Usuario } from '../entity/usuario';
import { AuthUsuarioService } from '../servicios/auth-usuario-service';
import {AdministrarUsuariosService} from '../administrar-usuarios/administrar-usuarios.service';
import {ValidarRegis} from './validar-regis';

import swal from 'sweetalert2';

@Component({
  selector: 'app-login-regis',
  templateUrl: './login-regis.component.html',
  styleUrls: ['./login-regis.component.scss']
})
export class LoginRegisComponent implements OnInit {

  titulo: string = 'Por favor, sign in';
  titulo2: string = 'Por favor, registrese';
  perfiles: Perfil[]=[];
  usuario: Usuario;
  isLogin: boolean;
  passwordDisabled: boolean = false;
  id: number;
  intentos: number;

  constructor(private authService: AuthUsuarioService,
    private router: Router,
    private activateRoute: ActivatedRoute,
    private perfilService: PerfilService,
    private administrarUsuarioService: AdministrarUsuariosService,
    private validarRegis: ValidarRegis) {
      this.usuario = new Usuario();
     }

  ngOnInit(): void {
    this.cargarPerfiles();
    this.cargarUsuario();

  }

  cargarPerfiles(): void{
    this.perfilService.getPerfil().subscribe(
      perfiles => {
        this.perfiles = perfiles;
      }
    );
  }

  cargarUsuario(): void{
    this.activateRoute.params.subscribe(params =>{
      //Id global para comprobar
        this.id = params['idUsuario'];
        //Mirar si quiere cambiar la password
        this.passwordDisabled = params ['condicion'];
        if(this.id){
          this.administrarUsuarioService.getUsuarioId(this.id).subscribe(
            (usuario) => {
              this.usuario = usuario;
            }
          );
        }
      }
    );
  }



  login(){
      //Validacion formulario

      if(this.usuario.password == null || this.usuario.email == null){
        //swal.fire('Error login', '¡Username o password vacíos!', 'error');
        return;
      }else if(!this.validarRegis.validarEmail(this.usuario.email)){
        //swal.fire('Error formato email','Formato de la dirección de email no válido','error');
        return;
      }

      this.authService.login(this.usuario).subscribe(response => {

        if(response.bloqueada){
          swal.fire('Error', `El usuario está bloqueado`, 'error');
          return;
        }

        this.authService.guardarUsuario(response.token);
        this.authService.guardarToken(response.token);
        let usuario = this.authService.usuario;

        if(usuario.perfil.nombreperfil==="ADMINISTRADOR"){
          this.router.navigate(['administrador/productos']);
        }else{
          this.router.navigate(['/productos']);
        }
        swal.fire('Login', `Hola ${usuario.nombre}  has iniciado sesion correctamente`, 'success');
      }, err => {
        if (err.status == 403){
            //Mensaje intentos
            //swal.fire('Contraseña',`Contraseña incorrecta. Número de intentos restantes: ${this.intentos}` ,'error');

            this.administrarUsuarioService.getIdUsuarioByEmail(this.usuario.email).subscribe( response =>
            {
              if(response.intentos>1){
                response.intentos--;
                this.administrarUsuarioService.update(response).subscribe();
              }else{
                response.intentos--;
                response.bloqueada = true;
                this.administrarUsuarioService.update(response).subscribe(response =>{
                  swal.fire('Contraseña',`Usuario bloqueado` ,'error');
                });
              }

            });
        }else if(err.status == 500){
          swal.fire('Error Login', 'Usuario o clave incorrecta!', 'error');
        }
      });
  }

  registrarse(){
    if(this.validarRegis.validarFormatoCampos(this.usuario, this.passwordDisabled)){
      if(this.id==undefined && this.isLogged()){
        this.crearUsuarioByAdmin();
      }else if(this.isLogged()){
        this.updateUsuario();
      }else{
        this.registroNormal();
      }

    }
  }

  registroNormal(): void{
    this.authService.registro(this.usuario).subscribe( response => {

      this.authService.guardarUsuario(response.token);
      this.authService.guardarToken(response.token);
      let usuario = this.authService.usuario;
      this.router.navigate(['/productos']);
      swal.fire('Login', `¡Bienvenid@ ${usuario.nombre}!`, 'success');

    }, err => {
      if(err.status == 500){
        swal.fire('Error', 'El email introducido ya está registrado en nuestro comercio. Pruebe con otro','error');
      }
    });
  }

  crearUsuarioByAdmin(): void{
    this.authService.registro(this.usuario).subscribe( response => {
      this.router.navigate(['/administrador/lista']);
      swal.fire('Usuario añadido', `¡Usuario ${response.nombre} añadido!`, 'success');
    }, err => {
      if(err.status == 500){
        swal.fire('Error', 'El email introducido ya está registrado en nuestro comercio. Pruebe con otro','error');
      }
    });
  }

  updateUsuario(): void{
    this.administrarUsuarioService.update(this.usuario).subscribe(
      usuario => {
          this.router.navigate(['/administrador/lista']);
          console.log(usuario);
          swal.fire('Actualizado', `¡Usuario ${usuario.nombre} actualizado!`, 'success');

      });
  }

  isLogged(): boolean{
    return this.authService.isAuthenticated();
  }

  compararPerfil(perfil: Perfil, perfil2: Perfil){
    if(perfil===undefined && perfil2===undefined){
      return true;
    }
      return perfil ===null || perfil2===null||perfil ===undefined || perfil2===undefined?
        false: perfil.idperfil === perfil2.idperfil
  }

  //SI es true no se puede editar
    passwordEditable(): boolean{
      return this.passwordDisabled;
    }

    deshabilitarSelect(perfil: Perfil): boolean{
      if(perfil===undefined && this.isLogged()){
        return true;
      }
        return perfil ===null || perfil ===undefined?
          true: perfil.idperfil === 1 && this.isLogged();
    }
}
