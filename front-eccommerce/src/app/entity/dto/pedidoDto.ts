import {UsuarioPedidoDto} from "./usuarioPedidoDto";
import {Pago} from "../pago";
import {ProductoPedido} from "./productopedido";


export class PedidoDto {
  id: number;
  precioTotal: number;
  idUsuario: UsuarioPedidoDto;
  idPago: Pago;
  productos: ProductoPedido[];
  realizado: number;
}
