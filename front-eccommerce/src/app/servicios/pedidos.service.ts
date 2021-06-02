import { Injectable } from '@angular/core';
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Pedido} from "../entity/pedido";
import {ActivatedRoute} from "@angular/router";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {ProductoPedidoDto} from "../entity/dto/productopedidodto";


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

  postPedido(pedido: PedidoDto): Observable<Pedido> {
    return this.http.post<Pedido>(this.url, pedido).pipe()

  }

  actualizarPedido(productos: ProductoPedidoDto, id: number): Observable<any> {
    return this.http.put<any>(`${this.url}/${id}`, productos).pipe()
  }
}
