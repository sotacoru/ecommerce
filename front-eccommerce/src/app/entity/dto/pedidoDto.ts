import {UsuarioPedidoDto} from "./usuarioPedidoDto";
import {Pago} from "../pago";


export class PedidoDto {
  id: number;
  precioTotal: number;
  idUsuario: UsuarioPedidoDto;
  idPago: Pago;


}
