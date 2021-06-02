
import {Pago} from "../pago";
import {UsuarioPedidoDto} from "./usuarioPedidoDto";


export class PedidoDto {
  precioTotal: number;
  idUsuario: UsuarioPedidoDto;
  pago:Pago ;
}
