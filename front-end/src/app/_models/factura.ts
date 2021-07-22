export class Factura{

    id : number
    rfc :String 
    subtotal: number
    impuestos :number 
    total: number
    creacion: number

    constructor(id, rfc, subtotal, impuestos, total, creacion){
        this.id = id
        this.rfc = rfc
        this.subtotal = subtotal
        this.impuestos = impuestos
        this.total = total
        this.creacion = creacion
    }
    

}