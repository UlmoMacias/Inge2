import { Component, OnInit } from '@angular/core';
import { Articulo } from 'src/app/_models/articulo';
import { Producto } from 'src/app/_models/producto';
import { ArticulosService } from 'src/app/_services/articulos.service';
import { ProductosService } from 'src/app/_services/productos.service';
import { ProductosComponent } from '../productos/productos.component';
import { FormGroup, FormBuilder } from '@angular/forms'
import { ThrowStmt } from '@angular/compiler';

declare var $: any

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.css']
})
export class ArticulosComponent implements OnInit {
  
  articulos : Articulo [] | any
  carrito : Producto [] = []; 
  productos : Producto [] | any
  carritoForm : FormGroup | any
  constructor(
    private articulosService: ArticulosService, private formBuilder: FormBuilder) { };

  ngOnInit(): void {
    this.carritoForm=this.formBuilder.group(
      {
        cantidad:[' ']
      }
    );
    this.getArticulos()
    this.getProductos()
  };

  //
  // id: number
  // cantidad: number
  // codigo: String
  // impuesto: number
  // precio_unitario: number
  // subtotal: number
  // total: number
  // id_factura: number
  getArticulos() {
    this.articulos = [new Articulo(1, 2, "codigo1", 0.23, 15, 30, 30.23, 1), new Articulo(2, 3, "codigo2", 0.32, 20, 40, 40.32, 2) ]
    //    this.regionService.getRegiones().subscribe(
    //      res=>{
    //        this.regiones = res
    //      },
    //      err=>{
    //        console.error(err)
    //      }
    //
    //    )
  }
  getProductos(){
    this.productos = [new Producto(1, "codigo2", "nombre", "descripcion", 1, 100, new Date("03 08 2021"), 12)]

  }
  aniadir(producto: Producto){
    //Cantidad 
    //Mostrar carrito
    console.log("agregando"+ JSON.stringify(producto))
    this.carrito.push(producto)
    console.log(JSON.stringify(this.carrito))
  }
  Vercarrito(){
    $("#carrito").modal("show")
  }


  obtenerCantidad(){
    console.log("Este es el obtener Cantidad")

  }

}
