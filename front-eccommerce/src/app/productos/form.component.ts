import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PrimeNGConfig } from 'primeng/api';
import { Producto } from './producto';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {InputTextModule} from 'primeng/inputtext';
import { ProductoService } from '../servicios/producto.service';
import { Categoria } from './categoria';
import Swal from 'sweetalert2';
import { HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  titulo: string = "Nuevo producto";
  producto: Producto = new Producto;
  categorias: Categoria[];
  public errores: string[];
  public fotoSeleccionada: File;
  constructor(
    private router: Router,
    private productoService: ProductoService,
    private primengConfig: PrimeNGConfig,
    private activateRoute: ActivatedRoute

  ) { }

  ngOnInit(): void {
   this.cargarProducto()

  }

  
  cargarProducto(): void {
    this.activateRoute.params.subscribe(params => {
      let id = params['id']
      if (id) {
        this.productoService.getProductosId(id).subscribe((producto) => this.producto = producto)
      }
    })
    this.productoService.getCategorias().subscribe(categoria => { this.categorias = categoria })
    console.log(this.categorias)
  }
  
  create(): void {
    this.productoService.create(this.producto).subscribe(
      response => {
        console.log(response.producto)
        if(!this.fotoSeleccionada){
          Swal.fire('Error ', `tiene que selecionar una foto`, 'error');
        }else{
          this.productoService.subirFoto(this.fotoSeleccionada, response.producto.id).subscribe(
            event => {
              if (event.type === HttpEventType.UploadProgress) {
              } else if (event.type === HttpEventType.Response) {
                let response: any = event.body;
                this.producto = response.cliente as Producto;
                /* Swal.fire('La foto se ha subido correctamente', response.message, 'success'); */
              }
              /* this.cliente = cliente; */
            }
          )
        }
      Swal.fire('Nuevo procuto', `Producto ${response.producto.nombre} creado con exito`, 'success') 
      },
      err => {
        this.errores = err.error.errors as string[];
      }
    );
  }

  seleccionarFoto(event) {
    this.fotoSeleccionada = event.target.files[0];
    console.log(this.fotoSeleccionada);
    if (this.fotoSeleccionada.type.indexOf('image') < 0) {
      Swal.fire('Error ', `El archivo debe ser tipo imagen`, 'error');
      this.fotoSeleccionada = null;
    }
  }

  update(): void {
    this.productoService.update(this.producto).subscribe(response => {
      if(!this.fotoSeleccionada){
        Swal.fire('Error ', `tiene que selecionar una foto`, 'error');
      }else{
        this.productoService.subirFoto(this.fotoSeleccionada, response.producto.id).subscribe(
          event => {
            if (event.type === HttpEventType.UploadProgress) {
            } else if (event.type === HttpEventType.Response) {
              let response: any = event.body;
              this.producto = response.cliente as Producto;
              /* Swal.fire('La foto se ha subido correctamente', response.message, 'success'); */
            }
            /* this.cliente = cliente; */
          }
        )
      }
      Swal.fire('Producto actualizado', `Prducto ${response.producto.nombre} actualizado con exito`, 'success')
    })


  }

}

