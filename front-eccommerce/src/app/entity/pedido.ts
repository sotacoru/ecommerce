import {Pago} from "./pago";
import {UsuarioPedidoDto} from "./dto/usuarioPedidoDto";
import {ProductoPedido} from "./dto/productopedido";


export class Pedido {

  id: number;
  precioTotal: number;
  realizado: number = 0;
  idUsuario: UsuarioPedidoDto;
  idPago: Pago;
  productos: ProductoPedido[];
}
