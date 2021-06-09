import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";
import {AuthUsuarioService} from "./auth-usuario-service";


@Injectable({
  providedIn: 'root'
})
export class ActivatedLoginService implements CanActivate {
  constructor(private authService: AuthUsuarioService, private router: Router) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | Promise<boolean> | boolean {
    if (this.authService.isAuthenticated()) {
      this.router.navigate(['/productos']);
      return false;
    }
    return true;
  }
}
