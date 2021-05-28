import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../usuarios/usuario';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthUsuarioService {

  private _usuario: Usuario;
  private _token: string;

  constructor(private http: HttpClient) { }

  public get usuario(): Usuario{
    if(this._usuario != null){
      return this._usuario;
    }else if( this._usuario = null && sessionStorage.getItem('usuario') != null){
      this._usuario = JSON.parse(sessionStorage.getItem('usuario')) as Usuario;
      return this._usuario;
    }
    return new Usuario();
  }

  public get token(): string{
    if(this._token != null){
      return this._token;
    }else if( this._usuario = null && sessionStorage.getItem('token') != null){
      this._token = sessionStorage.getItem('token');
      return this._token;
    }
    return null;
  }

  login(usuario: Usuario): Observable<any> {
    const urlEndPoint = 'http://localhost:8090/api/login';

    //const credenciales = btoa('AngularApp' + ':' + '1234.Abcd ');

    const httpHeaders = new HttpHeaders({'Content-Type': 'application/json',
  'Authorization': 'Basic ' });
    return this.http.post<any>(urlEndPoint,usuario, {headers: httpHeaders});
  }

  guardarUsuario(accessToken: string): void{
    let payload = accessToken.split[1];
    const playLoadDecoded = atob(payload);
    const values = JSON.parse(playLoadDecoded);
    this._usuario = new Usuario();
    this._usuario = payload.idUsuario;
    this._usuario.email = payload.email;
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
    if(payload != null && payload.user_name && payload.user_name.length>0){
      return true;
    }
    return false;
  }

  hasRole(role: string): boolean{
    if(this.usuario.perfil.includes(role)){
      return true;
    }
    return false;
  }

  logout(): void{
    this._token = null;
    this._usuario = null;
    sessionStorage.clear();
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('usuario');
  }
}
