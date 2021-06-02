import {Usuario} from "./usuario";
import {Pago} from "./pago";
import {ProductoPedido} from "./dto/productopedido";


export class Pedido {

  id:number;
  precioTotal: number;
  realizado: number=0;
  usuario: Usuario;
  pago:Pago ;
  productos: ProductoPedido[];
}
