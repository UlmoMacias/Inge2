export class Articulo {

    id : number
    cantidad: number
    codigo : String
    impuesto : number 
    precio_unitario : number
    subtotal : number
    total : number
    id_factura: number    

  constructor(
    id: number, 
    cantidad: number, 
    codigo: String, 
    impuesto: number , 
    precio_unitario: number, 
    subtotal: number, 
    total: number, 
    id_factura: number    
) {
    this.id = id
    this.cantidad = cantidad
    this.codigo = codigo
    this.impuesto = impuesto
    this.precio_unitario = precio_unitario
    this.subtotal = subtotal
    this.total = total
    this.id_factura = id_factura
  }


}