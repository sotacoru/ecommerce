import { Injectable } from '@angular/core';
import { Usuario } from '../usuarios/usuario';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdministrarUsuariosService {

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});

  constructor(private http: HttpClient) { }

  getUsuario(): Observable<Usuario[]>{
    return this.http.get('http://localhost:8090/api/usuario').pipe(
      map( response => response as Usuario[])
    );
  }

  deleteUsuario(id: number): Observable<Usuario>{
    return this.http.delete<Usuario>('http://localhost:8090/api/usuario/'+id,
      {headers: this.httpHeaders}).pipe();
  }

}
