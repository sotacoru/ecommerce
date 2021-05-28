import { Categoria } from "./categoria";

export class Producto {

    id:number;
    nombre: string;
    precio: number;
    descripcion: string;
    cantidad: number;
    foto: string;
    idcategoria: Categoria;
}
