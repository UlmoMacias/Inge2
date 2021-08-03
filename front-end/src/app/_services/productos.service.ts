import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Producto} from '../_models/producto'

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getProductos(){
    return this.http.get(this.API_URI+'/producto')
  }

  getProducto(codigo: String){
    return this.http.get(this.API_URI+'/producto/'+codigo)
  }

  createProducto(producto: Producto){
    return this.http.post(this.API_URI+'/producto' , producto)
  }

  updateProduct(codigo: number, producto : Producto){
    return this.http.put(this.API_URI+'/producto/'+codigo, producto)
  }
  
  deleteProducto(codigo: number){
    return this.http.delete(this.API_URI+'/producto/'+codigo)
  }

}
