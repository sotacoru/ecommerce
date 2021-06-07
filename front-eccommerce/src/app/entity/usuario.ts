import {Perfil} from './perfil';

export class Usuario {
  idusuario: number;
  nombre: string;
  primerapellido: string;
  segundoapellido: string;
  email: string;
  password: string;
  password2: string;
  perfil: Perfil;
}
