import {Articulo} from './articulo'
export class Factura{

    id : number
    fecha_creacion : Date
    rfc_cliente :String 
    subtotal: number
    codigo : number
    taxes :number 
    total: number
    articulos : Articulo[]

  constructor(
    id: number, 
    fecha_creacion: Date, 
    rfc_cliente: String , 
    subtotal: number, 
    codigo: number, 
    taxes: number , 
    total: number, 
    articulos: Articulo[]
) {
    this.id = id
    this.fecha_creacion = fecha_creacion
    this.rfc_cliente = rfc_cliente
    this.subtotal = subtotal
    this.codigo = codigo
    this.taxes = taxes
    this.total = total
    this.articulos = articulos
  }


}