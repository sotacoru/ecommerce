import { Categoria } from "./categoria";
import {Pedido} from "../pedidos/pedido";
import {Producto} from "./producto";

export class ProductoPedido {
  pedido:Pedido;
  producto:Producto;
  cantidad:number;
}
