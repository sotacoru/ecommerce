import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Usuario} from '../entity/usuario';
import {map} from "rxjs/operators";
import {UsuarioBusqueda} from "../entity/dto/usuario_busqueda";
import swal from "sweetalert2";


@Injectable({
  providedIn: 'root'
})
export class AuthUsuarioService {

  private _usuario: Usuario;
  private _token: string;
  private urlEndPoint: string = 'http://localhost:8090/api/usuario';

  constructor(private http: HttpClient,
    private router: Router) {
  }

  public get usuario(): Usuario {
    if (this._usuario != null) {
      return this._usuario;
    } else if (this._usuario == null && sessionStorage.getItem('usuario') != null) {
      this._usuario = JSON.parse(sessionStorage.getItem('usuario')) as Usuario;
      return this._usuario;
    }
    return null;
  }

  public get token(): string {
    if (this._token != null) {
      return this._token;
    } else if (this._usuario == null && sessionStorage.getItem('token') != null) {
      this._token = sessionStorage.getItem('token');
      return this._token;
    }
    return null;
  }

  registro(usuario: Usuario): Observable<any> {
    const urlEndPoint = 'http://localhost:8090/api/registro/usuario';

    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic '
    });

    return this.http.post<any>(urlEndPoint, usuario, {headers: httpHeaders});
  }

  login(usuario: Usuario): Observable<any> {
    const urlEndPoint = 'http://localhost:8090/api/login';

    //const credenciales = btoa('AngularApp' + ':' + '1234.Abcd ');

    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic '
    });
    return this.http.post<any>(urlEndPoint, usuario, {headers: httpHeaders});
  }


  guardarUsuario(accessToken: string): void {
    let payload = this.obtenerDatosToken(accessToken);

    this._usuario = new Usuario();
    this._usuario = payload;

    sessionStorage.setItem('usuario', JSON.stringify(this._usuario));
  }

  guardarToken(accessToken: string): void {
    this._token = accessToken;
    sessionStorage.setItem('token', accessToken);
  }

  obtenerDatosToken(accessToken: string): any {
    if (accessToken != null) {
      return JSON.parse(atob(accessToken.split(".")[1]));
    }

    return null;
  }

  isAuthenticated(): boolean {

    return !!this._token;

  }

  hasRole(role: string): boolean {
    if (this.usuario.perfil.nombreperfil.includes(role)) {
      return true;
    }
    return false;
  }

  logout(): void {
    swal.fire('Logout', 'Has cerrado sesión con éxito', 'success');
    this._token = null;
    this._usuario = null;
    sessionStorage.clear();
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('usuario');

    this.router.navigate(['/productos']);
  }

  getUsuario(): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.urlEndPoint}/${this.getSub()}`);
  }


  getUsuariosBusqueda(busqueda: UsuarioBusqueda): Observable<Usuario[]> {
    return this.http.post(this.urlEndPoint + '/busqueda', busqueda).pipe(
      map((response: any) => {
        return response;
      })
    )
  }

  public getSub(): number {
    if (!this.token) {
      return null;
    }
    const token = this.token;
    const payload = token.split('.')[1];
    const playloadDecoded = atob(payload);
    const values = JSON.parse(playloadDecoded);
    return values.sub;
  }

  public getPerfil(): any {

    let user = JSON.parse(window.sessionStorage.getItem("usuario"));
    if (user) {
      return user.perfil.nombreperfil
    }
  }

}
