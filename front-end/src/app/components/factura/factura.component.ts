import { Component, OnInit } from '@angular/core';
import {Factura} from 'src/app/_models/factura'
import {FacturaService} from 'src/app/_services/factura.service'
import {Producto } from '../../_models/producto'
import {Region} from '../../_models/region'
import {Cliente} from '../../_models/cliente'
import {Articulo} from '../../_models/articulo'
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import {ActivatedRoute } from '@angular/router'
import { ProductosService } from 'src/app/_services/productos.service';


declare var $: any

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {
  rfc: string;
  facturas : Factura [] | any
  articulos : Articulo [] | any
  productos : Producto [] | any

  constructor(private route: ActivatedRoute, private facturaService: FacturaService, private productosService: ProductosService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => { 
      this.rfc = params.rfc; 
    });   
    this.getFacturas()
  }
  getFacturas(){
    
  this.facturas = [new Factura(1, new Date("11 08 2019 ") , this.rfc, 12, 234, 123.45, 5656, [new Articulo(1,123,"codigo", 34, 56, 1,12, 123 ),new Articulo(2,123,"codigo1", 34, 56, 1,12, 123 ),new Articulo(3,123,"codigo2", 34, 56, 1,12, 123 )  ])]
//    this.facturaService.getFacturas(this.rfc).subscribe(
//      res => {
//        this.facturas = res
//      },
//      err => {
//        console.error(err)
//      }
//    )

  }

  detalleArticulos(id_factura: number){
  for (let a of this.facturas){
      if (id_factura == a.id ){
          this.articulos = a.articulos
          
        }
      }

    $("#nuevo").modal({
      backdrop: 'static'
    });
    $("#nuevo").modal("show")
  }

  detallesProducto(codigo:String ){
      this.productos = [new Producto(1, "codigo", "nombre", "describe", 1, 2, new Date("12 12 1997"), 1)]
//    this.productos.getProducto(codigo).subscribe(
//      res => {
//        this.productos = res
//      },
//      err => {
//        console.error(err)
//      }
//    )
    

    $("#nuevo").modal("hide")

    $("#productos").modal({
      backdrop: 'static'
    });
    $("#productos").modal("show")
    console.log("detalles producto")

  }



}
