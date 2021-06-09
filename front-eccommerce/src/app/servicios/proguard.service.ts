import {Injectable} from '@angular/core';
import Swal from "sweetalert2";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {AuthUsuarioService} from "./auth-usuario-service";

@Injectable({
  providedIn: 'root'
})
export class ProguardService implements CanActivate {
  realRole: string;

  constructor(private as: AuthUsuarioService, private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const expectedRole = route.data.expectedRol;
    if (!this.as.isAuthenticated()) {
      Swal.fire('No está logueado', 'haz login', 'error')
      this.router.navigate(['/login']);
      return false;
    }
    this.realRole = this.as.usuario.perfil.nombreperfil;
    if (expectedRole.indexOf(this.realRole) > 0) {
      return true
    }

    console.log('esperado ' + expectedRole + '\nReal: ' + this.realRole)

    console.log("no me hace la redirecion")
    Swal.fire('Sin Permisos', 'No tienes los permisos necesarios para hacer esto', 'error')
    this.router.navigate(['/productos']);

    return false;

  }
}
