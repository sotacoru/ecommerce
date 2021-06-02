import { Component, OnInit, Input } from '@angular/core';
import { HttpEventType } from '@angular/common/http';

import { Usuario } from '../usuarios/usuario';
import { ModalService } from './modal-perfil-user.component';
import { AuthUsuarioService } from '../servicios/auth-usuario-service';

import swal from 'sweetalert2';

@Component({
  selector: 'detalle-producto',
  templateUrl: './modal-perfil-user.component.html',
  styleUrls: ['./modal-perfil-user.component.scss']
})

export class DetalleComponent implements OnInit {

  @Input() usuario: Usuario;
  titulo: string = "Perfil de usuario";
  progreso: number = 0;

  constructor(
     private authService: AuthUsuarioService,
     public modalService: ModalService) { }

  ngOnInit() {
    this.authService.getUsuario().subscribe(usuarios => {
      this.usuario = usuarios;
      console.log(this.usuario.nombre);
    })
  }

    cerrarModal(){
      this.modalService.cerrarModal();
      this.progreso = 0;
    }

    
}
