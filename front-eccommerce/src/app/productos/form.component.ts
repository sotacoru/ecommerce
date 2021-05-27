import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PrimeNGConfig } from 'primeng/api';
import { Producto } from './producto';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {InputTextModule} from 'primeng/inputtext';
import { ProductoService } from '../servicios/producto.service';
import { Categoria } from './categoria';
import Swal from 'sweetalert2';

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
        //this.productoService.getProductos(id).subscribe((producto) => this.producto = producto)
      }
    })
    this.productoService.getCategorias().subscribe(categoria => { this.categorias = categoria })
    console.log(this.categorias)
  }
  
  create(): void {
    this.productoService.create(this.producto).subscribe(
      response => {
        console.log(response.producto)
       /*  this.router.navigate([''])
        Swal.fire('Nuevo cliente', `Cliente ${response.cliente.nombre} creado con exito`, 'success') */
      },
      err => {
        this.errores = err.error.errors as string[];
      }
    );
  }
}

