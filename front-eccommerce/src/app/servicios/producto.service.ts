import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest,} from '@angular/common/http';
import {catchError, map} from 'rxjs/operators'
import {ProductoBusqueda} from "../entity/dto/producto_busqueda";
import {Producto} from "../entity/producto";
import {Router} from '@angular/router';
import {Observable, throwError} from 'rxjs';
import {Categoria} from '../entity/categoria';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  private url: string = 'http://localhost:8090/api/producto'
  private adminurl: string = 'http://localhost:8090/api/administracion/producto'
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient, private router: Router) {
  }

  getProductos(): Observable<any> {
    return this.http.get(this.url + '/all').pipe(
      map((response: any) => {
        return response;
      }),
    )

  }


  getProductosId(id): Observable<Producto> {
    return this.http.get<Producto>(`${this.url}/${id}`).pipe(
      catchError(e => {
        if (e.status != 401 && e.error.mensaje)
          this.router.navigate(['/producto'])


        return throwError(e);
      })
    )
  }

  getProductosBusqueda(busqueda: ProductoBusqueda): Observable<Producto[]> {
    return this.http.post(this.url + '/busqueda', busqueda, {headers: this.httpHeaders}).pipe(
      map((response: any) => {
        return response;
      })
    )
  }

  getProductosCategoria(categoria: string): Observable<Producto[]> {
    return this.http.get<Producto[]>(`${this.url}/categoria/${categoria}`)
  }

  getCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.url + '/categorias');
  }

  getProducto(id): Observable<Producto> {
    return this.http.get<Producto>(`${this.url}/${id}`)
  }

  create(producto: Producto): Observable<any> {
    return this.http.post<Producto>(this.adminurl, producto).pipe(
      catchError(e => {
        if (e.status === 400) {
          return throwError(e);
        }
        return throwError(e);
      })
    )

  }


  update(producto: Producto): Observable<any> {
    return this.http.put<Producto>(`${this.adminurl}/${producto.id}`, producto).pipe(
      catchError(e => {


        if (e.status === 400) {
          return throwError(e);
        }


        return throwError(e);
      })
    )

  }


  subirFoto(archivo: File, id): Observable<HttpEvent<{}>> {
    let formdata = new FormData();
    formdata.append('archivo', archivo);
    formdata.append('id', id);


    const req = new HttpRequest('POST', `http://localhost:8090/api/administracion/productos/upload`, formdata)

    return this.http.request(req);


  }


  delete(id: number): Observable<Producto> {
    return this.http.delete<Producto>(`http://localhost:8090/api/administracion/producto/${id}`, {headers: this.httpHeaders}).pipe(
    )
  }

}




