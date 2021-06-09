import { Injectable } from '@angular/core';
import { Usuario } from '../entity/usuario';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdministrarUsuariosService {

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});

  constructor(private http: HttpClient) { }

  getUsuarioId(id: number): Observable<Usuario>{
    return this.http.get<Usuario>('http://localhost:8090/api/usuario/'+id).pipe();
  }

  getUsuario(): Observable<Usuario[]>{
    return this.http.get('http://localhost:8090/api/usuario').pipe(
      map( response => response as Usuario[])
    );
  }

  deleteUsuario(id: number): Observable<Usuario>{
    return this.http.delete<Usuario>('http://localhost:8090/api/usuario/'+id,
      {headers: this.httpHeaders}).pipe();
  }

  update(usuario: Usuario): Observable<Usuario>{
    return this.http.put<Usuario>('http://localhost:8090/api/usuario/'+usuario.idUsuario
        ,usuario,{headers: this.httpHeaders}).pipe();
  }

  getIdUsuarioByEmail(email: string): Observable<Usuario>{
    return this.http.post<Usuario>('http://localhost:8090/api/usuario/email',email, {headers: this.httpHeaders}).pipe();
  }

  //desbloquear
}
