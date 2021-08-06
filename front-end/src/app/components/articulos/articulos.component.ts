import { Component, OnInit } from '@angular/core';
import { Articulo } from 'src/app/_models/articulo';
import { Factura } from 'src/app/_models/factura';
import { Region } from 'src/app/_models/region';
import { ArticulosService } from 'src/app/_services/articulos.service';
import { ProductosService } from 'src/app/_services/productos.service';
import { ProductosComponent } from '../productos/productos.component';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import {Producto} from 'src/app/_models/producto';
import { FacturaService } from 'src/app/_services/factura.service';
import Swal from 'sweetalert2';
import {Cantidad} from 'src/app/_models/cantidad'

declare var $: any

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.css']
})
export class ArticulosComponent implements OnInit {
  
  articulos : Articulo [] | any
  factura : Factura [] | any
  carrito : Producto [] = []; 
  productos : Producto [] | any
  carritoForm : FormGroup | any
  agregando: Producto
  cantidad : Cantidad [] = []
  submitted = false
  
  
  constructor(
    private articulosService: ArticulosService, private formBuilder: FormBuilder) { };

  ngOnInit(): void {
    this.carritoForm=this.formBuilder.group(
      {
        cantidad:['', Validators.required]
      }
    );
    
    this.getProductos()
  };

  getProductos(){
    this.productos = [new Producto(1, "codigo2", "p1", "descripcion", 1, 100, new Date("03 08 2021"), 12),
                      new Producto(2, "codigo3", "p2", "desacripcion", 1, 100, new Date("03 08 2021"), 12),
                      new Producto(3, "codigo3", "p3", "desacripcion", 1, 100, new Date("03 08 2021"), 12)]

  }
  agregar(producto: Producto){
    this.agregando = producto
    this.carritoForm.reset()
    $("#cantidad").modal("show")
    
  }
  vercarrito(){
    $("#carrito").modal("show")
  }


  obtenerCantidad(){
    
    this.submitted = true

    if(this.carritoForm.invalid){ 
      this.showFail("inserta una cantidad :D")
      return
    }

    this.showSucces("Hecho! \n Se agregaron "+this.carritoForm.value.cantidad)    
    console.log("cantidad:" +this.carritoForm.value.cantidad)
    $("#cantidad").modal("hide")
    this.submitted=false
    
    this.carrito.push(this.agregando)
    this.cantidad.push(new Cantidad(this.agregando,this.carritoForm.value.cantidad ))
    
    for (let i of this.cantidad){
        console.log(i.producto)
        console.log(i.cantidad)
    }

    

  }

  eliminarDeCarrito(id){
    console.log(id)
  }



  get f () {return this.carritoForm.controls}

  showFail(message){
    Swal.fire({
      icon: 'error',
      title: message
      
    });
  }

  showSucces(message){
    Swal.fire({
      icon: 'success',
      title: message,
    });
  }





}
