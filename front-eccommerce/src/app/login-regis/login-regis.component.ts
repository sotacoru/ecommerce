import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Perfil} from '../entity/perfil';
import {PerfilService} from '../usuarios/perfil.service';
import {Usuario} from '../entity/usuario';
import {AuthUsuarioService} from '../servicios/auth-usuario-service';
import {AdministrarUsuariosService} from '../administrar-usuarios/administrar-usuarios.service';
import {ValidarRegis} from './validar-regis';

import swal from 'sweetalert2';

@Component({
  selector: 'app-login-regis',
  templateUrl: './login-regis.component.html',
  styleUrls: ['./login-regis.component.scss']
})
export class LoginRegisComponent implements OnInit {

  perfiles: Perfil[] = [];
  usuario: Usuario;
  isLogin: boolean;
  passwordDisabled: boolean = false;
  id: number;
  intentos: number;
  loginIncorrecto: String;
  registroIncorrecto: String;
  varMostrarPassword: boolean = false;

  constructor(private authService: AuthUsuarioService,
    private router: Router,
    private activateRoute: ActivatedRoute,
    private perfilService: PerfilService,
    private administrarUsuarioService: AdministrarUsuariosService,
    public validarRegis: ValidarRegis) {
      this.usuario = new Usuario();
     }

  ngOnInit(): void {
    this.cargarPerfiles();
    this.cargarUsuario();
  }

  cargarPerfiles(): void {
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

      this.authService.login(this.usuario).subscribe(response => {

        if(response.bloqueada){
          this.loginIncorrecto=`Su usuario está bloqueado, no puede iniciar sesión`;
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
          this.comprobarIntentosLogin();
        }else if(err.status == 500){
          this.loginIncorrecto = `Lamentablemente, ha habido un error en el inicio de sesión. Asegúrate de que estás utilizando la dirección de correo electrónico correcta.`;
        }
      });
  }

  comprobarIntentosLogin(): void{
    this.administrarUsuarioService.getIdUsuarioByEmail(this.usuario.email).subscribe( response =>
    {

      if(response.perfil.nombreperfil!='ADMINISTRADOR'){
        if(response.intentos>1){
          response.intentos--;
          this.loginIncorrecto = `Contraseña incorrecta. Número de intentos restantes: ${response.intentos}`;
          this.administrarUsuarioService.update(response).subscribe();
        }else if(response.intentos==1){
          console.log(response.intentos);
          console.log(response.bloqueada);
          response.intentos--;
          response.bloqueada = true;
          this.loginIncorrecto='';
          this.administrarUsuarioService.update(response).subscribe(response =>{
            swal.fire('Bloqueo de usuario',`Su usuario ha sido bloqueado ya que ha superado el número máximo de intentos.` ,'error');
          });
        }else{
          this.loginIncorrecto='El usuario al que está intentando acceder está bloqueado';
        }
      }else{
        this.loginIncorrecto='Contraseña incorrecta';
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
        this.registroIncorrecto='El email que indicas para crear el usuario ya existe en nuestro comercio. Por favor pruebe con otro';
      }
    });
  }

  crearUsuarioByAdmin(): void{
    this.authService.registro(this.usuario).subscribe( response => {
      this.router.navigate(['/administrador/lista']);
      swal.fire('Usuario añadido', `¡Usuario ${response.nombre} añadido!`, 'success');
    }, err => {
      if(err.status == 500){
        this.registroIncorrecto='El email introducido ya existe en este comercio';
      }
    });
  }

  updateUsuario(): void{
    this.administrarUsuarioService.update(this.usuario).subscribe(
      usuario => {
          this.router.navigate(['/administrador/lista']);
          swal.fire('Actualizado', `¡Usuario ${usuario.nombre} actualizado!`, 'success');
      }, err => {
        if(err.status == 500){
          this.registroIncorrecto='El email introducido ya existe en este comercio';
        }
    });


  }

  isLogged(): boolean {
    return this.authService.isAuthenticated();
  }

  compararPerfil(perfil: Perfil, perfil2: Perfil){
    if(perfil===undefined && perfil2===undefined){
      return true;
    }
      return perfil ===null || perfil2===null||perfil ===undefined || perfil2===undefined?
        false: perfil.idperfil === perfil2.idperfil
  }

  mostrarPassword(): void{
    if(!this.varMostrarPassword){
      this.varMostrarPassword=true;
    }else{
    this.varMostrarPassword=false;
    }
  }

    passwordEditable(): boolean {
    return this.passwordDisabled;
    }

    deshabilitarSelect(perfil: Perfil): boolean{

      if(perfil===undefined && this.isLogged()){
        return false;
      }else if(perfil===undefined && !this.isLogged()){
        return true;
      }
      else if((perfil.nombreperfil==='CLIENTE' && this.isLogged()) || perfil.nombreperfil==='ADMINISTRADOR'){
        return true;
      }
        return perfil ===null || perfil ===undefined?
          true: perfil.idperfil === 1 && this.isLogged();
    }

}
