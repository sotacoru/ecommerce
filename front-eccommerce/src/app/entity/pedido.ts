
import {Pago} from "./pago";
import {Producto} from "./producto";
import {UsuarioPedidoDto} from "./dto/usuarioPedidoDto";
import {ProductoPedido} from "./dto/productopedido";


export class Pedido {

  id:number;
  precioTotal: number;
  realizado: number=0;
  idUsuario: UsuarioPedidoDto;
  pago:Pago ;
  productos: ProductoPedido[];
}
