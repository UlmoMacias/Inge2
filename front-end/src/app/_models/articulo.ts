export class Articulo {

    id : number
    idfactura: number
    cantidad: number
    porcentaje : number 
    subtotal : number
    unitario: number 
    total : number

    constructor(id, idfactura, cantidad, porcentaje, subtotal, unitario, total){
        this.id = id
        this.idfactura = idfactura
        this.cantidad = cantidad
        this.porcentaje = porcentaje
        this.subtotal = subtotal
        this.unitario = unitario
        this.total  = total
    }

}