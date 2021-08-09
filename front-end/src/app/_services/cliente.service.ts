import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Cliente} from '../_models/cliente'

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  API_URI = 'http://localhost:8080';
  

  constructor(private http: HttpClient) { }

  getClientes(){
    return this.http.get(this.API_URI+"/cliente");
  }

  getCliente(rfc: String){
    return this.http.get(this.API_URI+"/cliente/"+rfc)
  }

  createCliente(cliente : Cliente){
    return this.http.post(this.API_URI+"/cliente",cliente)
  }

  editCliente(cliente : Cliente){
    return this.http.put(this.API_URI+"/cliente/"+cliente.id,cliente)
  }

  deleteCliente(id: number){
    return this.http.delete(this.API_URI+"/cliente/"+id)
  }


}
