import { Component, OnInit } from '@angular/core';
import { Articulo } from 'src/app/_models/articulo';
import { ArticulosService } from 'src/app/_services/articulos.service'

declare var $: any

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.css']
})
export class ArticulosComponent implements OnInit {
  
  articulos : Articulo [] | any
  constructor(
    private articulosService: ArticulosService) { };

  ngOnInit(): void {
    this.getArticulos()
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


}
