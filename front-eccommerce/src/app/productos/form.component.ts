import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PrimeNGConfig } from 'primeng/api';
import { Producto } from './producto';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {InputTextModule} from 'primeng/inputtext';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  titulo: string = "Nuevo producto";
  producto: Producto;
  constructor(
    private router: Router,
    private primengConfig: PrimeNGConfig,
    public pInputText: InputTextModule,
    public pInputTextarea:InputTextareaModule,
  ) { }

  ngOnInit(): void {
    this.primengConfig.ripple = true;

  }

  

  
}
