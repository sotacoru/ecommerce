import { Component, OnInit } from '@angular/core';
import {Usuario} from '../usuarios/usuario';
import { AdministrarUsuariosService } from './administrar-usuarios.service';
import { AuthUsuarioService } from '../servicios/auth-usuario-service';
import {Router, ActivatedRoute} from '@angular/router';
import Swal from "sweetalert2";

@Component({
  selector: 'app-administrar-usuarios',
  templateUrl: './administrar-usuarios.component.html',
  styleUrls: ['./administrar-usuarios.component.scss']
})
export class AdministrarUsuariosComponent implements OnInit {

  usuarios: Usuario[];
  nombreUsuario: string = this.authService.usuario.email;
  rolUsuario: string= this.authService.usuario.perfil.toString();

  constructor(private administrarUsuarioService: AdministrarUsuariosService,
  private authService: AuthUsuarioService,
  private router: Router,
  private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.administrarUsuarioService.getUsuario().subscribe( usuarios =>{
      this.usuarios = usuarios
    });
  }

  delete(usuario: Usuario): void{
    this.administrarUsuarioService.deleteUsuario(usuario.idusuario).subscribe(
      response => {
        this.usuarios = this.usuarios.filter(user => user !== usuario);
      }
    );
  }

  update(usuario: Usuario): void{
    console.log(usuario)
    this.administrarUsuarioService.update(usuario).subscribe(
      usuario => {
        this.router.navigate(['/administrador/actualizar']);
      }
    );
  }

  preguntaEditar(usuario: Usuario): void{
    if(usuario.perfil.nombreperfil=='CLIENTE'){
      this.router.navigate(['/administrador/actualizar/',usuario.idusuario,true]);
    }else{
      Swal.fire({
        title: 'Tipo de edición',
        text: `Como desea editar el usuario ¿con o sin contraseña?`,
        icon: 'info',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#69F129',
        confirmButtonText: 'Sin contraseña',
        cancelButtonText: 'Con contraseña',
        showDenyButton: true,
        denyButtonText: 'Cancelar'
      }).then((result) => {
        if(!result.isDenied){
          this.router.navigate(['/administrador/actualizar/',usuario.idusuario,result.isConfirmed]);
        }
      })
    }
  }
}
