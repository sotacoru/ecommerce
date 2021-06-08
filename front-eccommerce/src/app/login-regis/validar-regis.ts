import {Usuario} from '../entity/usuario';
import {Perfil} from '../entity/perfil';
import { Injectable } from '@angular/core';

import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class ValidarRegis{

  validarFormatoCampos(usuario: Usuario): boolean{

    if(!this.validarEmail(usuario.email)){

      swal.fire('Error formato email','El formato del correo electrónico no es válido. Ejemplo: ejemplo@gmail.com','error');
      return false;

    }else if(!this.validarPassword(usuario.password)){

      swal.fire('Error en el formato de la contraseña','La contraseña indicada debe contener minúsculas, mayúsculas y caracteres especiales de tipo:"." "," "/" "-" "_"','error');
      return false;

    }else if(!this.compararPassword(usuario.password, usuario.password2)){

      swal.fire('Error al comparar las contraseñas','Las contraseñas deben ser iguales','error');
      return false;

    }

    return true;
  }

  validarEmail(email: any): boolean{

    return /^\w+([\.-]?\w+)*@(?:|hotmail|outlook|yahoo|live|gmail|atos)\.(?:|com|es|gal|net|org)+$/.test(email);

  }

  validarPassword(password1: String): boolean{
      let minuscula: boolean=false;
      let mayuscula: boolean=false;
      let caracterEspecial: boolean = false;

      for(let i=0;i<password1.length;i++){
        if(this.esMayuscula(password1.charAt(i))&& !mayuscula){
          mayuscula=true;
        }

        if(this.esMinuscula(password1.charAt(i)) && !minuscula){
          minuscula=true;
        }

        if(this.esCaracterEspecial(password1.charAt(i)) && !caracterEspecial){
          caracterEspecial=true;
        }

        if(minuscula && mayuscula && caracterEspecial){
          return true;
        }
      }
    return false;
  }

  compararPassword(password1: String, password2:String): any{
    return password1==password2;
  }

  esMayuscula(letra: String): boolean{
    return letra==letra.toUpperCase();
  }

  esMinuscula(letra: String): boolean{
    return letra==letra.toLowerCase();
  }

  esCaracterEspecial(letra: String): boolean{
    let caracterEspecial = [".", ",", "/", "-", "_"];
    for(let caracter of caracterEspecial){
      if(caracter==letra){
        return true;
      }
    }
    return false;
  }

}
