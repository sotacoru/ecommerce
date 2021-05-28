
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {catchError, map} from 'rxjs/operators'
import {ProductoBusqueda} from "../productos/producto_busqueda";
import {Producto} from "../productos/producto";
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
}
