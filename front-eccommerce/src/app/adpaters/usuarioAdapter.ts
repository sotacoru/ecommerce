import {Usuario} from "../entity/usuario";
import {UsuarioPedidoDto} from "../entity/dto/usuarioPedidoDto";

export class UsuarioAdapter {

  usuarioToUsuarioPedido(u: Usuario): UsuarioPedidoDto {
    let usuarioDto: UsuarioPedidoDto = new UsuarioPedidoDto();
    usuarioDto.idUsuario = u.idUsuario;
    usuarioDto.nombre = u.nombre;
    usuarioDto.email = u.email;
    usuarioDto.primerApellido = u.primerapellido;
    usuarioDto.segundoApellido = u.segundoapellido;
    return usuarioDto;
  }
}
