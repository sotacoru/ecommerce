import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../usuarios/usuario';
import jwt_decode from 'jwt-decode';

import swal from 'sweetalert2';


@Injectable({
  providedIn: 'root'
})
export class AuthUsuarioService {

  private _usuario: Usuario;
  private _token: string;
  private  urlEndPoint: string = 'http://localhost:8090/api/usuario';
  private id:number;

  constructor(private http: HttpClient) { }

  public get usuario(): Usuario{
    if(this._usuario != null){
      return this._usuario;
    }else if( this._usuario == null && sessionStorage.getItem('usuario') != null){
      this._usuario = JSON.parse(sessionStorage.getItem('usuario')) as Usuario;
      return this._usuario;
    }
    return new Usuario();
  }

  public get token(): string{
    if(this._token != null){
      return this._token;
    }else if( this._usuario == null && sessionStorage.getItem('token') != null){
      this._token = sessionStorage.getItem('token');
      return this._token;
    }
    return null;
  }

  registro(usuario: Usuario): Observable<any>{
    const urlEndPoint = 'http://localhost:8090/api/registro/usuario';

    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json',
      'Authorization': 'Basic ' });

    return this.http.post<any>(urlEndPoint,usuario, {headers: httpHeaders});
  }

  login(usuario: Usuario): Observable<any> {
    const urlEndPoint = 'http://localhost:8090/api/login';

    //const credenciales = btoa('AngularApp' + ':' + '1234.Abcd ');

    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json',
  'Authorization': 'Basic ' });
    return this.http.post<any>(urlEndPoint,usuario, {headers: httpHeaders});
  }

  guardarUsuario(accessToken: string): void{
    let payload = this.obtenerDatosToken(accessToken);

    this._usuario = new Usuario();
    this._usuario=payload;

    sessionStorage.setItem('usuario', JSON.stringify(this._usuario));
  }

  guardarToken(accessToken: string): void{
    this._token = accessToken;
    sessionStorage.setItem('token', accessToken);
  }

  obtenerDatosToken(accessToken: string): any{
    if(accessToken != null){
      return JSON.parse(atob(accessToken.split(".")[1]));
    }

    return null;
  }

  isAuthenticated(): boolean{
    let payload = this.obtenerDatosToken(this.token);
    if(payload != null && payload.nombre && payload.nombre.length>0){
      return true;
    }
    return false;
  }

  hasRole(role: string): boolean{
    if(this.usuario.perfil.nombreperfil.includes(role)){
      return true;
    }
    return false;
  }

  logout(): void{
    swal.fire('Logout', `${this._usuario.nombre}, has cerrado sesión con éxito`, 'success');
    this._token = null;
    this._usuario = null;
    sessionStorage.clear();
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('usuario');

  }

  getUsuario():Observable<Usuario>{
    return this.http.get<Usuario>(`${this.urlEndPoint}/${this.getSub()}`);
  }

  guardarSubToken(accessToken: string): void{
    let payload = this.obtenerDatosToken(accessToken);
    this.id = payload;

    sessionStorage.setItem('sub', JSON.stringify(this.id));
  }

  public getSub(): number {
    if(!this.token){
      return null;
    }
    const token = this.token;
    const payload = token.split('.')[1];
    const playloadDecoded = atob(payload);
    const values= JSON.parse(playloadDecoded);
    return values.sub;
  }

}
