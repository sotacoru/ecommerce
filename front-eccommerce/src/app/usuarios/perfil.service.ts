import { Injectable } from '@angular/core';
import { Perfil } from '../entity/perfil';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  constructor(private http: HttpClient) { }

  getPerfil(): Observable<Perfil[]>{
    return this.http.get<Perfil[]>('http://localhost:8090/api/perfil').pipe(

    );
  }
}
