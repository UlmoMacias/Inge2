import {Producto} from 'src/app/_models/producto'

export class Cantidad {

    producto : Producto
    cantidad : number

    constructor (producto: Producto, cantidad: number){
        this.producto = producto
        this.cantidad = cantidad
    }


}