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
      console.log(this.usuario);
      if(this.usuario.password == null || this.usuario.email == null){
        swal.fire('Error login', '¡Username o password vacíos!', 'error');
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
}
