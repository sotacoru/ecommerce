

import {Usuario} from "../usuario";
import {Pago} from "../pago";


export class PedidoDto {
  precioTotal: number;
  idUsuario: Usuario;
  pago:Pago ;
}
