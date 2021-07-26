import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Categoria} from '../_models/categoria'

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getCategorias(){
    return this.http.get(this.API_URI+"/categorias")
  }

  getCategoria(id: number){
    return this.http.get(this.API_URI+"/categoria/"+id)
  }

  createCategoria(categoria: Categoria){
    return this.http.post(this.API_URI+"/categoria", categoria)
  }

  updateCategoria(categoria: Categoria){
    return this.http.put(this.API_URI+"/categoria/"+categoria.id, categoria)
  }

  deleteCategoria(id:number){
    return this.http.delete(this.API_URI+"/categoria/"+id)
  }


}
