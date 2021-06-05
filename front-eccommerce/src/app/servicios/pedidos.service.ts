import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Pedido} from "../entity/pedido";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {ProductoPedido} from "../entity/dto/productopedido";
import {Pago} from "../entity/pago";


@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  private url: string = 'http://localhost:8090/api/pedido'
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private productos: ProductoPedido[] = [];
  private pedido = new BehaviorSubject<Pedido>(null);

  constructor(private http: HttpClient) {

  }

  getPedido(): Observable<Pedido> {
    return this.pedido.asObservable();
  }

  postPedido(pedido: PedidoDto) {
    console.log(pedido)
    return this.http.post<any>(this.url, pedido).pipe().subscribe(
      response => {
        console.log(response)
        this.pedido.next(response.pedido)
      }
    )

  }

  setProductosPedido(p: ProductoPedido) {

    const productoArray = this.contains(p.producto.id);

    if (productoArray === null) {
      this.productos.push(p);
    } else {
      productoArray.cantidad++;
    }
    window.localStorage.setItem('productos', JSON.stringify(this.productos));
  }

  deleteProductosPedido() {
    window.localStorage.removeItem("productos")
  }

  getProductosPedido() {
    return JSON.parse(window.localStorage.getItem('productos'));
  }

  getPagos(): Observable<Pago[]> {
    return this.http.get<Pago[]>(this.url + '/pagos');
  }

  confirmarPedido(pedido: PedidoDto, id: number): Observable<any> {
    pedido.productos = this.getProductosPedido()
    this.deleteProductosPedido()
    return this.http.put<any>(`${this.url}/${id}`, pedido).pipe();
  }

  contains(id: number): ProductoPedido {
    for (const p of this.productos) {
      if (p.producto.id === id) {
        return p;
      }
    }

    return null;
  }
}
