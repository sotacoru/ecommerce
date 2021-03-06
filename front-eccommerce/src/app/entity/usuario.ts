import {Perfil} from './perfil';

export class Usuario {
  idUsuario: number;
  idusuario: number;
  nombre: string;
  primerapellido: string;
  segundoapellido: string;
  email: string;
  password: string;
  password2: string;
  perfil: Perfil;
  bloqueada: boolean;
  intentos: number;
}
