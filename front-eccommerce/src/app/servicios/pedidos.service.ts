import { Injectable } from '@angular/core';
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Pedido} from "../entity/pedido";
import {ActivatedRoute} from "@angular/router";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {ProductoPedidoDto} from "../entity/dto/productopedidodto";
import {ProductoPedido} from "../entity/dto/productopedido";


@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  private url: string = 'http://localhost:8090/api/pedido'
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private  productos: ProductoPedido[] = [];
  constructor(private http: HttpClient) {

  }

  getPedido(id: number): Observable<Pedido> {
    return this.http.get<Pedido>(`${this.url}/${id}`).pipe()
  }

  postPedido(pedido: PedidoDto): Observable<Pedido> {
    return this.http.post<Pedido>(this.url, pedido).pipe()

  }
  setProductosPedido(p: ProductoPedido){
    this.productos.push(p)
    window.localStorage.setItem('productos', JSON.stringify(this.productos))
  }
  getProductosPedido(): ProductoPedido[]{
   return JSON.parse( window.localStorage.getItem('productos'));
  }
  actualizarPedido(productos: ProductoPedidoDto, id: number): Observable<any> {
    return this.http.put<any>(`${this.url}/${id}`, productos).pipe()
  }
}
