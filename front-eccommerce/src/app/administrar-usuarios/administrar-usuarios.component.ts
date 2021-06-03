import { Component, OnInit } from '@angular/core';
import {Usuario} from '../usuarios/usuario';
import { AdministrarUsuariosService } from './administrar-usuarios.service';
import { AuthUsuarioService } from '../servicios/auth-usuario-service';
import {Router, ActivatedRoute} from '@angular/router';

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
}
