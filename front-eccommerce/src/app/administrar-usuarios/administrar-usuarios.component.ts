import {Component, OnInit} from '@angular/core';
import {Usuario} from '../entity/usuario';
import {AdministrarUsuariosService} from './administrar-usuarios.service';
import {AuthUsuarioService} from '../servicios/auth-usuario-service';
import {ActivatedRoute, Router} from '@angular/router';
import Swal from "sweetalert2";
import {UsuarioBusqueda} from "../entity/dto/usuario_busqueda";

@Component({
  selector: 'app-administrar-usuarios',
  templateUrl: './administrar-usuarios.component.html',
  styleUrls: ['./administrar-usuarios.component.scss']
})
export class AdministrarUsuariosComponent implements OnInit {

  usuarios: Usuario[];
  nombreUsuario: string = this.authService.usuario.email;
  rolUsuario: string = this.authService.usuario.perfil.nombreperfil.toString();
  busqueda: UsuarioBusqueda = new UsuarioBusqueda();

  constructor(private administrarUsuarioService: AdministrarUsuariosService,
              private authService: AuthUsuarioService,
              private router: Router,
              private activateRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.cargarUsuarios();
  }

  public cargarUsuarios() {
    this.administrarUsuarioService.getUsuario().subscribe(usuarios => {
      this.usuarios = usuarios
    });
  }

  delete(usuario: Usuario): void {
    Swal.fire({
      title: 'Eliminar',
      text: `¿Estás seguro de que quieres eliminar a ${usuario.nombre}?`,
      icon: 'info',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#69F129',
      confirmButtonText: 'Sí, estoy seguro',
      cancelButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
        this.administrarUsuarioService.deleteUsuario(usuario.idusuario).subscribe(
          response => {
            this.usuarios = this.usuarios.filter(user => user !== usuario);
          }
        );

        Swal.fire('Eliminado', `¡Usuario ${usuario.nombre} eliminado!`, 'success');
      }
    })

  }

  update(usuario: Usuario): void {
    this.administrarUsuarioService.update(usuario).subscribe(
      usuario => {
        this.router.navigate(['/administrador/actualizar']);
      }
    );
  }

  preguntaEditar(usuario: Usuario): void {
    if (usuario.perfil.nombreperfil == 'CLIENTE') {
      this.router.navigate(['/administrador/actualizar/', usuario.idUsuario, true]);
    } else {
      Swal.fire({
        title: 'Tipo de edición',
        text: `Como desea editar el usuario ¿con o sin contraseña?`,
        icon: 'info',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#69F129',
        confirmButtonText: 'Sin contraseña',
        cancelButtonText: 'Con contraseña',
      }).then((result) => {
        if (!result.isDenied) {
          this.router.navigate(['/administrador/actualizar/', usuario.idUsuario, result.isConfirmed]);
        }
      })
    }
  }

  preguntaDesbloquear(usuario: Usuario): void {
    Swal.fire({
      title: 'Desbloqueo',
      text: `¿Desea desbloquear a este usuario?`,
      icon: 'info',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#69F129',
      confirmButtonText: 'Sí',
      cancelButtonText: 'No',
    }).then((result) => {
      if (!result.isDismissed) {
        this.administrarUsuarioService.getIdUsuarioByEmail(usuario.email).subscribe(response => {
          response.intentos = 3
          response.bloqueada = false;
          this.administrarUsuarioService.update(response).subscribe(response => {
            window.location.reload();
          });
        });
      }
    });
  }

  addSecretarioAdmin(): void {
    this.router.navigate(['/administrador/añadir']);
  }

  buscar() {
    this.authService.getUsuariosBusqueda(this.busqueda).subscribe(
      res => this.usuarios = res
    )
  }
}
