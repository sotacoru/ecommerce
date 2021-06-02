import { Component, OnInit, Input } from '@angular/core';
import { Usuario } from '../usuarios/usuario';
import { ModalUsuarioService } from './modal-usuario.service';
import { AuthUsuarioService } from '../servicios/auth-usuario-service';

import swal from 'sweetalert2';


@Component({
  selector: 'app-modal-usuario',
  templateUrl: './modal-usuario.component.html',
  styleUrls: ['./modal-usuario.component.scss']
})
export class ModalUsuarioComponent implements OnInit {

  @Input() usuario: Usuario;
  titulo: string = "Perfil de usuario";

  constructor(
     private authService: AuthUsuarioService,
     public modalService: ModalUsuarioService) { }

  ngOnInit() {
    this.usuario = this.authService.usuario;
  }

    cerrarModal(){
      this.modalService.cerrarModal();
    }
}
