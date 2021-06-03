import { Component, OnInit } from '@angular/core';
import {Usuario} from '../usuarios/usuario';
import { AdministrarUsuariosService } from './administrar-usuarios.service';
import { AuthUsuarioService } from '../servicios/auth-usuario-service';

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
  private authService: AuthUsuarioService) { }

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

}
