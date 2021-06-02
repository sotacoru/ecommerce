import {Perfil} from './perfil';

export class Usuario {
  idUsuario: number;
  nombre: string;
  primerapellido: string;
  segundoapellido: string;
  email: string;
  password: string;
  password2: string;
  idPerfil: Perfil;
}
