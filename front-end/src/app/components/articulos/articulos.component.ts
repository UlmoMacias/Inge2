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
import { ActivatedRoute } from '@angular/router'


declare var $: any

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.css']
})
export class ArticulosComponent implements OnInit {
  
  rfc: string;
  articulos : Articulo [] = []
  factura : Factura [] | any
  carrito : Producto [] = []; 
  productos : Producto [] | any
  carritoForm : FormGroup | any
  agregando: Producto
  cantidad : Cantidad [] = []
  submitted = false
  
  
  constructor(private route: ActivatedRoute,
    private articulosService: ArticulosService, 
    private formBuilder: FormBuilder,
    private productosService: ProductosService,
    private facturaService: FacturaService) { };

  ngOnInit(): void {

    this.route.queryParams.subscribe(
      params => {
                  this.rfc = params.rfc;
    });
    this.carritoForm=this.formBuilder.group(
      {
        cantidad:['', Validators.required]
      }
    );
    
    this.getProductos()
  };

  getProductos(){
    this.productos = []
    this.productosService.getProductos().subscribe(
      res => {
        this.productos = res
        console.log(JSON.stringify( res))
      },
      err => {
        console.error(err)
      }
    )



  }
  agregar(producto: Producto){
    this.agregando = producto
    this.carritoForm.reset()
    $("#cantidad").modal("show")
    
  }
  vercarrito(){
    $("#carrito").modal({
      backdrop: 'static'
    });
    $("#carrito").modal("show")
  }


  obtenerCantidad(){
    
    this.submitted = true

    if(this.carritoForm.invalid){ 
      this.showFail("inserta una cantidad :D")
      return
    }

    if (this.carritoForm.value.cantidad <= this.agregando.cantidad){
    
      this.showSucces("Hecho! \n Se agregaron "+this.carritoForm.value.cantidad)    
      console.log("cantidad:" +this.carritoForm.value.cantidad)
      $("#cantidad").modal("hide")
      this.submitted=false
      this.cantidad.push(new Cantidad(this.agregando,this.carritoForm.value.cantidad ))
  
    }else{
      this.showFail("la cantidad es mayor a los productos en stock :C")
      return
    }

  }


  generarFactura(){

    for (let i of this.cantidad){
      this.articulos.push(new Articulo(null,i.cantidad, i.producto.codigo, .5,null, null, null, null ))
      var  p = new Producto( i.producto.id,
                             i.producto.codigo, 
                             i.producto.nombre, 
                             i.producto.descripcion, 
                             i.producto.cantidad - i.cantidad, 
                             i.producto.precio, 
                             i.producto.fecha_creacion, 
                            i.producto.id_categoria)
      console.log("newP: "+ JSON.stringify(p))

      this.productosService.updateProduct(i.producto.codigo, p).subscribe(
          res => {
            console.log("resupdate : "+JSON.stringify( res))
            console.log("update porductos")
            
          }, 
          err => {
              console.log("error update articulos:"+ JSON.stringify( err))
          }

        )

        var a = new Articulo(null,i.cantidad, i.producto.codigo, .5,null, null, null, null )
          console.log("articulo: "+ JSON.stringify (a))

      this.articulosService.createArticulo(a).subscribe(
      
          res => {    
            console.log("res subiendo articulos: "+JSON.stringify( res))
            console.log("subiendo articulos...")
          }, 
          err => {
            console.log("error createArticulo: "+  err)

        }
      )

    }

    
    var today = new Date();
      today.setDate(today.getDate() + 1);
      var dd = String(today.getDate()).padStart(2, '0');
      var mm = String(today.getMonth() + 1).padStart(2, '0');
      var yyyy = String(today.getFullYear());
      
      const hoy = yyyy + '-' + mm + '-' + dd;

      const factura = new Factura (null, new Date (hoy), this.rfc, null, null, null,null, this.articulos)

      this.facturaService.createFactura(factura).subscribe(
        res => {
          console.log(res)
          console.log(factura)
          this.getProductos()
          $("#carrito").modal("hide")
          this.showSucces("Factura Creada!")
        },
        err => {
          this.showFail("No se pudo crear la factura :C ")
        }
      ) 

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
