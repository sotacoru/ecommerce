import {Usuario} from "../usuarios/usuario";
import {Pago} from "../usuarios/pago";
import {ProductoPedido} from "../productos/productopedido";


export class Pedido {

  id:number;
  precioTotal: number;
  realizado: number=0;
  usuario: Usuario;
  pago:Pago ;
  productos: ProductoPedido[];
}
