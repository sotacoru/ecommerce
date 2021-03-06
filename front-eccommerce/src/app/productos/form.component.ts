import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PrimeNGConfig } from 'primeng/api';
import { Producto } from '../entity/producto';
import { ProductoService } from '../servicios/producto.service';
import { Categoria } from '../entity/categoria';
import Swal from 'sweetalert2';
import { HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  titulo: string;
  producto: Producto = new Producto();
  categorias: Categoria[];
  public fotoSeleccionada: File;
  public errores: string[];

  constructor(
    private router: Router,
    private productoService: ProductoService,
    private primengConfig: PrimeNGConfig,
    private activateRoute: ActivatedRoute
  ) {
    this.producto = new Producto()
  }

  ngOnInit(): void {
    //En el caso de tener id busca el producto 
    this.cargarProducto()
    if (this.producto.id) {
      this.titulo = "Actualizar Producto"
    } else {
      this.titulo = "Nuevo producto"
    }


  }


  cargarProducto(): void {
    this.productoService.getCategorias().subscribe(categoria => {
      this.categorias = categoria
    })
    this.activateRoute.params.subscribe(params => {
      let id = params['id']
      if (id) {
        this.productoService.getProducto(id).subscribe((producto) => {
          this.producto = producto
        }
        )
        this.productoService.getProductosId(id).subscribe((producto) => this.producto = producto)

      }
    })


  }

  //Crea un nuevo producto
  create(): void {
    this.productoService.create(this.producto).subscribe(
      response => {

        if (!this.fotoSeleccionada) {
          Swal.fire('Error ', `tiene que selecionar una foto`, 'error');
        } else {
          this.productoService.subirFoto(this.fotoSeleccionada, response.producto.id).subscribe(
            event => {
              if (event.type === HttpEventType.UploadProgress) {
              } else if (event.type === HttpEventType.Response) {
                let response: any = event.body;
                this.producto = response.producto as Producto;
                Swal.fire('La foto se ha subido correctamente', response.message, 'success');

              }
            }
          )
        }
        Swal.fire('Nuevo procuto', `Producto ${response.producto.nombre} creado con exito`, 'success').then(
          r => this.router.navigate(['/productos'])
        )

      },
      err => {
        this.errores = err.error.errors as string[];
      }
    );

  }

  //Optiene el la imagen del formulario
  seleccionarFoto(event) {
    this.fotoSeleccionada = event.target.files[0];

    if (this.fotoSeleccionada.type.indexOf('image') < 0) {
      Swal.fire('Error ', `El archivo debe ser tipo imagen`, 'error');
      this.fotoSeleccionada = null;
    }
  }

  //Actualiza el producto
  update(): void {
    this.productoService.update(this.producto).subscribe(response => {
      if (this.fotoSeleccionada) {

        this.productoService.subirFoto(this.fotoSeleccionada, response.producto.id).subscribe(
          event => {
            if (event.type === HttpEventType.UploadProgress) {
            } else if (event.type === HttpEventType.Response) {
              let response: any = event.body;
              this.producto = response.cliente as Producto;
            }
          }
        )
      }

      Swal.fire('Producto actualizado', `Producto ${response.producto.nombre} actualizado con exito`, 'success').then(
        r => this.router.navigate(['/productos'])
      )

    })


  }


  compararCategoriaa(o1: Categoria, o2: Categoria): boolean {
    if (o1 === undefined && o2 === undefined) {
      return true;
    }
    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false : o1.id === o2.id
  }

}
