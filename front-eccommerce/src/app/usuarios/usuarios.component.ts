import { Component, OnInit } from '@angular/core';
import { ModalUsuarioService } from '../modal-usuario/modal-usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {

  abierto: boolean = false;

  constructor(private modalService: ModalUsuarioService) { }

  ngOnInit() {
  }

  abrirModal2(){
    this.modalService.abrirModal();
    this.abierto = true;
  }

}
