import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Pedido} from "../entity/pedido";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {ProductoPedido} from "../entity/dto/productopedido";
import {Pago} from "../entity/pago";


@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  private url: string = 'http://localhost:8090/api/pedido'
  private productos = new BehaviorSubject<ProductoPedido[]>([]);
  private pedido = new BehaviorSubject<Pedido>(null);

  constructor(private http: HttpClient) {

  }

  getPedido(): Observable<Pedido> {
    return this.pedido.asObservable();
  }

  getProductosPedido(): Observable<ProductoPedido[]> {
    return this.productos.asObservable();
  }

  postPedido(pedido: PedidoDto) {
    return this.http.post<any>(this.url, pedido).pipe().subscribe(
      response => {
        this.pedido.next(response.pedido)
      }
    )

  }

  setProductosPedido(p: ProductoPedido) {

    const productoArray = this.contains(p.producto.id);

    if (productoArray === null) {
      this.productos.value.push(p);
    } else {
      productoArray.cantidad++;
    }
    window.localStorage.setItem('productos', JSON.stringify(this.productos));
    this.productos.next(this.productos.value);

  }

  getTotalPedido(): number {
    let total: number = 0;
    this.productos.value.forEach(
      p => total = total + (p.producto.precio * p.cantidad)
    )
    return total
  }

  restarCantidadProducto(p: ProductoPedido) {
    const productoArray = this.contains(p.producto.id);

    if (productoArray !== null && productoArray.cantidad > 0) {
      productoArray.cantidad--;
    }
    if (productoArray.cantidad == 0) {
      this.deleteProductoCarrito(p)
    }
    window.localStorage.setItem('productos', JSON.stringify(this.productos));
  }

  deleteProductoCarrito(p: ProductoPedido) {
    const productoArray = this.contains(p.producto.id);

    if (productoArray !== null) {
      let i = this.productos.value.indexOf(p);
      this.productos.value.splice(i, 1);
    }
    window.localStorage.setItem('productos', JSON.stringify(this.productos));

  }

  sumarCantidadProducto(p: ProductoPedido) {
    const productoArray = this.contains(p.producto.id);

    if (productoArray !== null) {
      productoArray.cantidad++;
    }
    window.localStorage.setItem('productos', JSON.stringify(this.productos));

  }

  deleteProductosPedido() {
    window.localStorage.removeItem("productos")
  }

  /*getProductosPedido() {
    return JSON.parse(window.localStorage.getItem('productos'));
  }*/

  getPagos(): Observable<Pago[]> {
    return this.http.get<Pago[]>(this.url + '/pagos');
  }

  confirmarPedido(pedido: PedidoDto, id: number): Observable<any> {
    pedido.productos = this.productos.value
    this.deleteProductosPedido()
    return this.http.put<any>(`${this.url}/${id}`, pedido).pipe();
  }

  contains(id: number): ProductoPedido {
    for (const p of this.productos.value) {
      if (p.producto.id === id) {
        return p;
      }
    }

    return null;
  }


}
