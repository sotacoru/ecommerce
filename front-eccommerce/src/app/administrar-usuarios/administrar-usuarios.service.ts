import { Injectable } from '@angular/core';
import { Usuario } from '../usuarios/usuario';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdministrarUsuariosService {

  constructor(private http: HttpClient) { }

  getUsuario(): Observable<Usuario[]>{
    return this.http.get('http://localhost:8090/api/usuario').pipe(
      map( response => response as Usuario[])
    );
  }
}
