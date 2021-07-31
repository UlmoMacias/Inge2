import { Component, OnInit } from '@angular/core';
import {Factura} from 'src/app/_models/factura'
import {FacturaService} from 'src/app/_services/factura.service'
import {Producto } from '../../_models/producto'
import {Region} from '../../_models/region'
import {Cliente} from '../../_models/cliente'
import {Articulo} from '../../_models/articulo'
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import {ActivatedRoute } from '@angular/router'


declare var $: any

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {
  rfc: string;
  facturas : Factura [] | any

  constructor(private route: ActivatedRoute, private facturaService: FacturaService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => { 
      this.rfc = params.rfc; 
    });   
    this.getFacturas()
  }
  getFacturas(){
    
    this.facturas = []//[new Factura(1, new Date("11 08 2019 ") , this.rfc, 12, 234, 123.45, 5656, [new Articulo(1,123,"asdasd", 34, 56, 1,12, 123 )]), new Factura(2, new Date("11 08 2019 ") , this.rfc, 12, 234, 123.45, 5656, [new Articulo(1,123,"asdasd", 34, 56, 1,12, 123 )]),new Factura(1, new Date("11 08 2019 ") , this.rfc, 12, 234, 123.45, 5656, [new Articulo(1,123,"asdasd", 34, 56, 1,12, 123 )]), new Factura(2, new Date("11 08 2019 ") , this.rfc, 12, 234, 123.45, 5656, [new Articulo(1,123,"asdasd", 34, 56, 1,12, 123 )]),new Factura(1, new Date("11 08 2019 ") , this.rfc, 12, 234, 123.45, 5656, [new Articulo(1,123,"asdasd", 34, 56, 1,12, 123 )]), new Factura(2, new Date("11 08 2019 ") , this.rfc, 12, 234, 123.45, 5656, [new Articulo(1,123,"asdasd", 34, 56, 1,12, 123 )])]
//    this.facturaService.getFacturas(this.rfc).subscribe(
//
//    )


  }



}
