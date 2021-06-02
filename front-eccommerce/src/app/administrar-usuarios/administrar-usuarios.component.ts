import { Component, OnInit } from '@angular/core';
import {Usuario} from '../usuarios/usuario';
import { AdministrarUsuariosService } from './administrar-usuarios.service';

@Component({
  selector: 'app-administrar-usuarios',
  templateUrl: './administrar-usuarios.component.html',
  styleUrls: ['./administrar-usuarios.component.scss']
})
export class AdministrarUsuariosComponent implements OnInit {

  usuarios: Usuario[];

  constructor(private administrarUsuarioService: AdministrarUsuariosService) { }

  ngOnInit(): void {
    this.administrarUsuarioService.getUsuario().subscribe( usuarios =>{
      console.log(usuarios[0].perfil);
      this.usuarios = usuarios
    });
  }

}
