import {Injectable} from '@angular/core';
import {Observable} from "rxjs";

import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Pedido} from "../pedidos/pedido";

import {PedidoDto} from "../pedidos/pedidoDto";

import {ProductoPedidoDto} from "../productos/productopedidodto";

@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  private url: string = 'http://localhost:8090/api/pedido'
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {

  }

  getPedido(id: number): Observable<Pedido> {
    return this.http.get<Pedido>(`${this.url}/${id}`).pipe()
  }

  postPedido(pedido: PedidoDto): Observable<any> {
    return this.http.post<any>(this.url, pedido).pipe()

  }

  actualizarPedido(productos: ProductoPedidoDto, id: number): Observable<any> {
    return this.http.put<any>(`${this.url}/${id}`, productos).pipe()
  }
}
