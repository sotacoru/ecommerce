import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Usuario } from '../usuarios/usuario';
import { AuthUsuarioService } from '../servicios/auth-usuario-service';

import swal from 'sweetalert2';

@Component({
  selector: 'app-login-regis',
  templateUrl: './login-regis.component.html',
  styleUrls: ['./login-regis.component.scss']
})
export class LoginRegisComponent implements OnInit {

  titulo: string = 'Por favor, sign in';
  titulo2: string = 'Por favor, registrese';
  usuario: Usuario;
  isLogin: boolean;

  constructor(private authService: AuthUsuarioService,
    private router: Router) {
      this.usuario = new Usuario();
     }

  ngOnInit() {
  }


  login(){
      //Validacion formulario

      if(this.usuario.password == null || this.usuario.email == null){
        swal.fire('Error login', '¡Username o password vacíos!', 'error');
        return;
      }else if(!this.validarEmail(this.usuario.email)){
        swal.fire('Error formato email','Formato de la dirección de email no válido','error');
        return;
      }

      this.authService.login(this.usuario).subscribe(response => {

        this.authService.guardarUsuario(response.token);
        this.authService.guardarToken(response.token);

        let usuario = this.authService.usuario;
        this.router.navigate(['/productos']);
        swal.fire('Login', `Hola ${usuario.nombre}  has iniciado sesion correctamente`, 'success');
      }, err => {
        if (err.status == 403){
          swal.fire('Error Login', 'Usuario o clave incorrecta!', 'error');
        }
      });
  }

  registrarse(){
    if(this.validarCamposVacios() && this.validarLongitudCampos() && this.validarFormatoCampos()){

        this.authService.registro(this.usuario).subscribe( response => {
          console.log(response)
          this.authService.guardarUsuario(response.token);
          this.authService.guardarToken(response.token);

          let usuario = this.authService.usuario;
          this.router.navigate(['/productos']);
          swal.fire('Login', `¡Bienvenid@ ${usuario.nombre}!`, 'success');
        }, err => {
          if (err.status == 403){
            swal.fire('Error Login', 'Usuario o clave incorrecta!', 'error');
          }
          else if(err.status == 500){
            swal.fire('Error', 'El email introducido ya está registrado en nuestro comercio. Pruebe con otro','error');
          }
        });
    }
  }

  validarCamposVacios(): boolean{

    if(this.usuario.nombre==null){

        swal.fire('Campo nombre vacío','El campo nombre está vacío','error');
        return false;

    }else if(this.usuario.primerapellido==null){

      swal.fire('Campo Primer apellido vacío','El campo primer apellido está vacío','error');
      return false;

    }else if(this.usuario.segundoapellido==null){

      swal.fire('Campo segundo apellido vacío','El campo segundo apellido está vacío','error');
      return false;

    }else if(this.usuario.email==null){

      swal.fire('Campo email vacío','El campo primer apellido está vacío','error');
      return false;

    }else if(this.usuario.password==null){

      swal.fire('Campo contraseña vacío','El campo contraseña está vacío','error');
      return false;

    }else if(this.usuario.password2==null){

      swal.fire('Campo confirmar contraseña vacío','El campo confirmar contraseña está vacío','error');
      return false;

    }

    return true;
  }

  validarLongitudCampos(): boolean{

    if(!this.comprobarLongitudCamposNombreAps(this.usuario.nombre)){

      swal.fire('Longitud campo nombre inválida','La longitud mínima para el primer apellido es de 2 y la máxima de 20','error');
      return false;

    }else if(!this.comprobarLongitudCamposNombreAps(this.usuario.primerapellido)){

      swal.fire('Longitud campo primer apellido inválida','La longitud mínima para el campo primer apellido es de 2 y la máxima de 20','error');
      return false;

    }else if(!this.comprobarLongitudCamposNombreAps(this.usuario.segundoapellido)){

      swal.fire('Longitud campo segundo apellido inválida','La longitud mínima para el campo segundo apellido es de 2 y la máxima de 20','error');
      return false;

    }else if(!this.comprobarLongitudCampoEmail(this.usuario.email)){
      swal.fire('Longitud campo correo electrónico inválida','La longitud mínima para el campo correo electrónico es de 10 y la máxima de 320','error');

    }else if(!this.comprobarLongitudCampoPassword(this.usuario.password)){

      swal.fire('Longitud campo contraseña inválida','La longitud mínima para el campo contraseña es de 6 y la máxima de 30','error');
      return false;

    }

    return true;
  }

  validarFormatoCampos(): boolean{

    if(!this.validarEmail(this.usuario.email)){

      swal.fire('Error formato email','El formato del correo electrónico no es válido. Ejemplo: ejemplo@gmail.com','error');
      return false;

    }else if(!this.validarPassword(this.usuario.password)){

      swal.fire('Error en el formato de la contraseña','La contraseña indicada debe contener minúsculas, mayúsculas y caracteres especiales de tipo:"." "," "/" "-" "_"','error');
      return false;

    }else if(!this.compararPassword(this.usuario.password, this.usuario.password2)){

      swal.fire('Error al comparar las contraseñas','Las contraseñas deben ser iguales','error');
      return false;

    }

    return true;
  }

  validarEmail(email: any): boolean{

    return /^\w+([\.-]?\w+)*@(?:|hotmail|outlook|yahoo|live|gmail)\.(?:|com|es)+$/.test(email);

  }

  validarPassword(password1: String): boolean{

    let minuscula: boolean=false;
    let mayuscula: boolean=false;
    let caracterEspecial: boolean = false;

    for(let i=0;i<password1.length;i++){
      if(this.esMayuscula(password1.charAt(i))&& !mayuscula){
        mayuscula=true;
      }

      if(this.esMinuscula(password1.charAt(i)) && !minuscula){
        minuscula=true;
      }

      if(this.esCaracterEspecial(password1.charAt(i)) && !caracterEspecial){
        caracterEspecial=true;
      }

      if(minuscula && mayuscula && caracterEspecial){
        return true;
      }
    }
    return false;
  }

  compararPassword(password1: String, password2:String): any{
    return password1==password2;
  }

  //Campos nombre, primer apellido, segundo apellido
  comprobarLongitudCamposNombreAps(cadena: String): boolean{
    return cadena.length>=2 && cadena.length<=20;
  }

  comprobarLongitudCampoEmail(cadena: String){
    return cadena.length>=10 && cadena.length<=320;
  }

  comprobarLongitudCampoPassword(cadena: String){
    return cadena.length>=6 && cadena.length<=30;
  }

  esMayuscula(letra: String): boolean{
    return letra==letra.toUpperCase();
  }

  esMinuscula(letra: String): boolean{
    return letra==letra.toLowerCase();
  }

  esCaracterEspecial(letra: String): boolean{
    let caracterEspecial = [".", ",", "/", "-", "_"];
    for(let caracter of caracterEspecial){
      if(caracter==letra){
        return true;
      }
    }
    return false;
  }
}
