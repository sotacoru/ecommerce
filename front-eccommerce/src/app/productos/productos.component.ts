import {ProductoService} from '../servicios/producto.service';
import {Component, OnInit} from '@angular/core';
import {Producto} from '../entity/producto'
import {PrimeNGConfig, SelectItem} from 'primeng/api';
import {ProductoBusqueda} from "../entity/dto/producto_busqueda";
import {ActivatedRoute} from "@angular/router";
import {PedidoDto} from "../entity/dto/pedidoDto";
import {PedidosService} from "../servicios/pedidos.service";
import {AuthUsuarioService} from "../servicios/auth-usuario-service";
import {UsuarioAdapter} from "../adpaters/usuarioAdapter";
import {ProductoAdapter} from "../adpaters/productoAdapter";

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {
  productos: Producto[];
  busqueda: ProductoBusqueda;
  pedido: PedidoDto;
  sortOptions: SelectItem[];
  sortOrder: number;
  sortField: string;
  urlImg: string = "http://localhost:8090/api/uploads/img/"
  imgDefecto: string = "http://localhost:8090/images/notImagen.jpg"
  private ua: UsuarioAdapter = new UsuarioAdapter();
  private pa: ProductoAdapter = new ProductoAdapter()

  constructor(private ps: ProductoService,
              private pedidoService: PedidosService,
              private primengConfig: PrimeNGConfig,
              private route: ActivatedRoute,
              private authService: AuthUsuarioService) {
    this.busqueda = new ProductoBusqueda();
  }

  ngOnInit() {
    this.route.params.subscribe(
      params => {
        let categoria: string = params.categoria;
        if (categoria === undefined) {
          this.ps.getProductos().subscribe(
            response => this.productos = response
          );
        } else {
          this.ps.getProductosCategoria(categoria).subscribe(
            response => {
              this.productos = response
            }
          )
        }
      })

    this.sortOptions = [
      {label: 'Más caros primero', value: '!precio'},
      {label: 'Más baratos primero', value: 'precio'}
    ];
    this.primengConfig.ripple = true;
  }


  perfil(): any {

    let user = JSON.parse(window.sessionStorage.getItem("usuario"));
    if (user) {
      return user.rol
    }
  }

  onSortChange(event) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    } else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }

  buscar() {
    this.ps.getProductosBusqueda(this.busqueda).subscribe(
      response => this.productos = response
    );
  }


}
