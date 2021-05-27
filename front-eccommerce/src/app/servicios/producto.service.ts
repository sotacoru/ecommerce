import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators'
import { Categoria } from '../productos/categoria';
import { Producto } from '../productos/producto';
@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  private url: string = 'http://localhost:8090/api/producto'
  //private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http: HttpClient, private router: Router) { }

  getProductos(): Observable<any> {
    return this.http.get(this.url + '/stock').pipe(
      map((response: any) => {
        return response;
      }),
    )
  }

  getCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.url + '/categorias');
  }

  create(producto: Producto): Observable<any> {
    console.log(producto)
    return this.http.post<Producto>("http://localhost:8090/api/administracion/producto", producto).pipe(
      catchError(e => {
        if (e.status === 400) {
          return throwError(e);
        }
        /* if(e.error.mensaje){
         
        } */
        return throwError(e);
      })

    )

  }
}

