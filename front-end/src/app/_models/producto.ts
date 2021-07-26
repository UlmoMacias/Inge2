export class Producto{

    id : number
    codigo : number
    nombre: String
    descripcion : String
    cantidad : number
    precio : number
    fecha_creacion : Date
    id_categoria : number


  constructor(
    id: number, 
    codigo: number, 
    nombre: String, 
    descripcion: String, 
    cantidad: number, 
    precio: number, 
    fecha_creacion: Date, 
    id_categoria: number
) {
    this.id = id
    this.codigo = codigo
    this.nombre = nombre
    this.descripcion = descripcion
    this.cantidad = cantidad
    this.precio = precio
    this.fecha_creacion = fecha_creacion
    this.id_categoria = id_categoria
  }


}