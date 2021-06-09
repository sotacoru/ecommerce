import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Perfil} from '../entity/perfil';
import {PerfilService} from '../usuarios/perfil.service';
import {Usuario} from '../entity/usuario';
import {AuthUsuarioService} from '../servicios/auth-usuario-service';
import {AdministrarUsuariosService} from '../administrar-usuarios/administrar-usuarios.service';

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

  constructor(private authService: AuthUsuarioService,
              private router: Router,
              private activateRoute: ActivatedRoute,
              private perfilService: PerfilService,
              private administrarUsuarioService: AdministrarUsuariosService) {
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

  cargarUsuario(): void {
    console.log('entre');
    this.activateRoute.params.subscribe(params => {
        let id = params['idusuario'];
        //Mirar si quiere cambiar la password
        this.passwordDisabled = params ['condicion'];
        if (id) {
          this.administrarUsuarioService.getUsuarioId(id).subscribe(
            (usuario) => {
              this.usuario = usuario;
            }
          );
        }
      }
    );
  }


  login() {
    //Validacion formulario

    if (this.usuario.password == null || this.usuario.email == null) {
      swal.fire('Error login', '¡Username o password vacíos!', 'error');
      return;
    } else if (!this.validarEmail(this.usuario.email)) {
      swal.fire('Error formato email', 'Formato de la dirección de email no válido', 'error');
      return;
    }

    this.authService.login(this.usuario).subscribe(response => {

      this.authService.guardarUsuario(response.token);
      this.authService.guardarToken(response.token);

      let usuario = this.authService.usuario;
      this.router.navigate(['/productos']);
      swal.fire('Login', `Hola ${usuario.nombre}  has iniciado sesion correctamente`, 'success');
    }, err => {
      if (err.status == 403) {
        swal.fire('Error Login', 'Usuario o clave incorrecta!', 'error');
      }
    });
  }

  registrarse() {
    if (this.validarFormatoCampos()) {
      console.log(this.isLogged());
      console.log(this.passwordEditable());
      //Si editable = undefined significa que entró a añadir un usuario;
      if (this.isLogged() && this.passwordEditable() != undefined) {

        this.administrarUsuarioService.update(this.usuario).subscribe(
          usuario => {
            console.log(usuario.nombre);
            this.router.navigate(['/administrador/lista']);
            swal.fire('Actualizado', `¡Usuario ${usuario.nombre} actualizado!`, 'success');
          });
        //Si está logueado y editable = undefined significa que es un admin añadiendo a un usuario
      } else if (this.isLogged() && this.passwordEditable() == undefined) {
        this.authService.registro(this.usuario).subscribe(response => {

          this.router.navigate(['/administrador/lista']);
          swal.fire('Usuario añadido', `¡Usuario ${response.nombre} añadido!`, 'success');
        }, err => {
          if (err.status == 500) {
            swal.fire('Error', 'El email introducido ya está registrado en nuestro comercio. Pruebe con otro', 'error');
          }
        });
      } else {
        this.authService.registro(this.usuario).subscribe(response => {
          this.authService.guardarUsuario(response.token);
          this.authService.guardarToken(response.token);
          let usuario = this.authService.usuario;
          this.router.navigate(['/productos']);
          swal.fire('Login', `¡Bienvenid@ ${usuario.nombre}!`, 'success');
        }, err => {
          if (err.status == 500) {
            swal.fire('Error', 'El email introducido ya está registrado en nuestro comercio. Pruebe con otro', 'error');
          }
        });
      }
    }
  }

  isLogged(): boolean {
    return this.authService.isAuthenticated();
  }

  validarFormatoCampos(): boolean {

    if (!this.validarEmail(this.usuario.email)) {

      swal.fire('Error formato email', 'El formato del correo electrónico no es válido. Ejemplo: ejemplo@gmail.com', 'error');
      return false;

    } else if (!this.validarPassword(this.usuario.password)) {

      swal.fire('Error en el formato de la contraseña', 'La contraseña indicada debe contener minúsculas, mayúsculas y caracteres especiales de tipo:"." "," "/" "-" "_"', 'error');
      return false;

    } else if (!this.compararPassword(this.usuario.password, this.usuario.password2)) {

      swal.fire('Error al comparar las contraseñas', 'Las contraseñas deben ser iguales', 'error');
      return false;

    }

    return true;
  }

  validarEmail(email: any): boolean {

    return /^\w+([\.-]?\w+)*@(?:|hotmail|outlook|yahoo|live|gmail|atos)\.(?:|com|es|gal|net|org)+$/.test(email);

  }

  validarPassword(password1: String): boolean {
    console.log(this.passwordEditable());
    if (this.passwordEditable() == undefined || this.passwordEditable()) {
      let minuscula: boolean = false;
      let mayuscula: boolean = false;
      let caracterEspecial: boolean = false;

      for (let i = 0; i < password1.length; i++) {
        if (this.esMayuscula(password1.charAt(i)) && !mayuscula) {
          mayuscula = true;
        }

        if (this.esMinuscula(password1.charAt(i)) && !minuscula) {
          minuscula = true;
        }

        if (this.esCaracterEspecial(password1.charAt(i)) && !caracterEspecial) {
          caracterEspecial = true;
        }

        if (minuscula && mayuscula && caracterEspecial) {
          return true;
        }
      }
    } else {
      return true;
    }
    return false;
  }


  compararPassword(password1: String, password2: String): any {
    return password1 == password2;
  }

  esMayuscula(letra: String): boolean {
    return letra == letra.toUpperCase();
  }

  esMinuscula(letra: String): boolean {
    return letra == letra.toLowerCase();
  }

  esCaracterEspecial(letra: String): boolean {
    let caracterEspecial = [".", ",", "/", "-", "_"];
    for (let caracter of caracterEspecial) {
      if (caracter == letra) {
        return true;
      }
    }
    return false;
  }

  compararPerfil(perfil: Perfil, perfil2: Perfil) {
    if (perfil === undefined && perfil2 === undefined) {
      return true;
    }
    return perfil === null || perfil2 === null || perfil === undefined || perfil2 === undefined ?
      false : perfil.idperfil === perfil2.idperfil
  }

  //SI es true no se puede editar
  passwordEditable(): boolean {
    return this.passwordDisabled;
  }

  deshabilitarSelect(perfil: Perfil): boolean {
    if (perfil === undefined && this.isLogged()) {
      return false;
    } else if (perfil === undefined && !this.isLogged()) {
      return true;
    } else if (perfil.nombreperfil === 'CLIENTE' && this.isLogged()) {
      return true;
    }
    return perfil === null || perfil === undefined ?
      true : perfil.idperfil === 1 && this.isLogged();
  }
}
