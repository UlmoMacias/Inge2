import {Region} from '../_models/region'
export class Cliente{

    id : number
    nombres : String
    apellidos :String
    rfc : String
    correo: String
    id_region: number

  constructor(
    id: number, 
    nombres: String, 
    apellidos: String, 
    rfc: String, 
    correo: String, 
    id_region:  number
) {
    this.id = id
    this.nombres = nombres
    this.apellidos = apellidos
    this.rfc = rfc
    this.correo = correo
    this.id_region = id_region
  }


  

    

}