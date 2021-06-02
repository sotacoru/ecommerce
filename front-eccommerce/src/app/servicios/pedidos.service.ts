import { Injectable } from '@angular/core';
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Pedido} from "../pedidos/pedido";
import {ActivatedRoute} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  private url: string = 'http://localhost:8090/api/pedido'
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {

  }
  getPedido(id:number):Observable<Pedido> {
    return this.http.get<Pedido>(`${this.url}/${id}`).pipe()
  }
}
