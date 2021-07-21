import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import {Factura} from '../_models/factura';


@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) {   }

//hay que checar esto

  getFacturas(){
    return this.http.get(this.API_URI+"/facturas")
  }

  getFactura(id: number){
    return this.http.get(this.API_URI+"/factura/"+id)
  }

  createFactura(factura: Factura){
    return this.http.post(this.API_URI+"/factura", factura)
  }

  editFactura(factura: Factura){
    return this.http.put(this.API_URI+"/factura/"+factura.id, factura)
  }

  deleteFactura(id: number){
    return this.http.delete(this.API_URI+"/factura/"+id);
  }  

}
