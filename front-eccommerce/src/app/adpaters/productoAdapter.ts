import {Producto} from "../entity/producto";
import {ProductoPedido} from "../entity/dto/productopedido";

export class ProductoAdapter {

  productoPedidoAdapter(p: Producto): ProductoPedido {
    let pp: ProductoPedido = new ProductoPedido();
    pp.producto = p;
    if (pp.cantidad == undefined)
      pp.cantidad = 1
    return pp;
  }
}
