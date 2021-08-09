import { Component, OnInit } from '@angular/core';
import { Factura } from 'src/app/_models/factura'
import { FacturaService } from 'src/app/_services/factura.service'
import { Producto } from '../../_models/producto'
import { Region } from '../../_models/region'
import { Cliente } from '../../_models/cliente'
import { Articulo } from '../../_models/articulo'
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router'
import { ProductosService } from 'src/app/_services/productos.service';
import Swal from 'sweetalert2';

declare var $: any

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {
  rfc: string;
  facturas: Factura[] | any
  articulos: Articulo[] | any
  productos: Producto[] | any
  factura : Factura

  constructor(private route: ActivatedRoute, private facturaService: FacturaService, 
    private productosService: ProductosService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.rfc = params.rfc;
    });
    this.getFacturas()
  }
  getFacturas() {

    //this.facturas = [new Factura(1, new Date("11 08 2019 "), this.rfc, 12, 234, 123.45, 5656, [new Articulo(1, 123, "codigo", 34, 56, 1, 12, 123), new Articulo(2, 123, "codigo1", 34, 56, 1, 12, 123), new Articulo(3, 123, "codigo2", 34, 56, 1, 12, 123)])]
    this.facturas = []    
    this.facturaService.getFacturas(this.rfc).subscribe(
          res => {
            this.facturas = res
            console.log("facturas")
          },
          err => {
            console.log("no se encontraron facturas !")
            console.error(err)
          }
        )
  }

  eliminaFactura(id_factura: number) {
    this.facturaService.deleteFactura(id_factura).subscribe(
      res => {
        this.showSucces("¡Factura eliminada! \n\n ❌")
        this.getFacturas()
      },
      err => {
        this.showFail("No se pudo eliminar \n\n 😭")
      }
    )
  }


  detalleArticulos(factura: Factura) {

    this.factura = factura
    this.articulos = factura.articulos
    console.log(this.articulos)
    $("#nuevo").modal({
      backdrop: 'static'
    });
    $("#nuevo").modal("show")
  }

  getProductos(codigo){
    console.log("producto: "+codigo)
        
        this.productosService.getProducto(codigo).subscribe(
          res => {
            this.productos = [res]
            console.log(res)
          },
          err => {
            console.error(err)
          }
        )
  }

  detallesProducto(codigo: String) {
    
    this.getProductos(codigo)

    $("#nuevo").modal("hide")

    $("#productos").modal({
      backdrop: 'static'
    });
    $("#productos").modal("show")
    console.log("detalles producto")

  }

  
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

