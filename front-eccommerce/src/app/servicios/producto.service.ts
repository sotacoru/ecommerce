import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import {catchError, map} from 'rxjs/operators'
import {ProductoBusqueda} from "../productos/producto_busqueda";
import {Producto} from "../productos/producto";
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { Categoria } from '../productos/categoria';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  private url:string = 'http://localhost:8090/api/producto'
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http:HttpClient, private router: Router) { }
  getProductos():Observable<any>{
    return this.http.get(this.url + '/stock').pipe(
      map((response:any)=>{
       return response;
      }),

    )

  }
  getProductosBusqueda(busqueda: ProductoBusqueda ):Observable<Producto[]>{
    return this.http.post(this.url + '/busqueda',busqueda,{headers:this.httpHeaders}).pipe(
      map((response:any)=>{
        return response;
      })
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

  getProducto(id): Observable<Producto> {
    return this.http.get<Producto>(`${this.url}/${id}`).pipe(
      
    )
  }

  update(producto: Producto): Observable<any> {
    return this.http.put<Producto>(`http://localhost:8090/api/administracion/producto/{id}/${producto.id}`, producto).pipe(
      catchError(e => {


        if (e.status === 400) {
          return throwError(e);
        }


        return throwError(e);
      })
    )

  }

}




