import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Articulo} from '../_models/articulo';

@Injectable({
  providedIn: 'root'
})
export class ArticulosService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  getArticulos(){
    return this.http.get(this.API_URI+"/articulos")
  }

  getArticulo(id: number){
    return this.http.get(this.API_URI+"/acticulos/"+id)
  }

  createArticulo(articulo: Articulo){
    return this.http.post(this.API_URI+"/articulo", articulo)
  }

  editArticulo(articulo : Articulo){
    return this.http.put(this.API_URI+"/articulo/"+articulo.id, articulo)
  }

  deleteArticulo(id: number){
    return this.http.delete(this.API_URI+"/articulo/"+id);
  }  

}
