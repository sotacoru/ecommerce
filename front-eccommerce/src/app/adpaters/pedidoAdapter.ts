import {PedidoDto} from "../entity/dto/pedidoDto";
import {Pedido} from "../entity/pedido";

export class PedidoAdapter {

  pedidoAdapter(pedido: Pedido): PedidoDto {
    let p: PedidoDto = new PedidoDto();
    p.id = pedido.idUsuario.idUsuario;
    p.realizado = pedido.realizado
    p.precioTotal = pedido.precioTotal;
    p.idUsuario = pedido.idUsuario;
    p.idPago = pedido.idPago;
    return p;
  }
}
