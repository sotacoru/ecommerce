import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';

import {AuthUsuarioService} from '../../servicios/auth-usuario-service';
import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(private authService: AuthUsuarioService,
              private router: Router) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    if (!this.authService.isAuthenticated()) {
      this.router.navigate(['/login']);
      return false;
    }

    let role = next.data['perfil'] as string;

    if (this.authService.hasRole(role)) {
      return true;
    }
    swal.fire('Acceso denegado', 'Hola ${this.authService.usuario.nombre} no tienes acceso a este recurso!', 'warning');
    this.router.navigate(['/productos']);
    return false;
  }

}
