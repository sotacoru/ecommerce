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
        console.log(response);
        this.authService.guardarUsuario("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTYyMjE1MjIyMn0.MYP5Y-MhqW9MsNaniQoAGzu85j4GnzwpPWldUWHo_jw");
        this.authService.guardarToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjIyMTMwNjQxLCJleHAiOjE2MjI2MzEyOTUsImVtYWlsIjoiZW1haWwxIiwicm9sIjoiQ0xJRU5URSJ9.yYp7LuDb4IM3-QlGuXkys9LLmB0z0-n3bp-iBJ5FGDw");

        let usuario = this.authService.usuario;
        this.router.navigate(['/productos']);
        swal.fire('Login', `Hola ${this.usuario.nombre}, has iniciado sesion correctamente`, 'success');
      }, err => {
        if (err.status == 400){
          swal.fire('Error Login', 'Usuario o clave incorrecta!', 'error');
        }
      });
  }
}
