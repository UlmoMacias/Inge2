import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Region } from 'src/app/_models/region';
import { ClienteService } from 'src/app/_services/cliente.service';
import {Cliente} from '../../_models/cliente'
import {RegionService} from 'src/app/_services/region.service'

declare var $:any;

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clientes : Cliente [] | any 
  regiones : Region [] | any
  summited = false


  constructor(
    private clienteService: ClienteService , 
    private regionService: RegionService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

  this.getClientes()
  this.getRegiones()

  }

  getClientes(){

    this.clientes = [new Cliente(1,"nombre", "apellido", "rfc1", "correo", 1),new Cliente(1,"nombre", "apellido", "rfc2", "correo", 2)]
    console.log(this.clientes.length )
    /*this.clienteService.getClientes().subscribe(
      res => {
        this.clientes = res
      },
      err => {
        console.error(err)
      }
    )
    */
  }

  getRegiones(){
    this.regiones = [new Region(1, "oaxaca"),new Region(2, "oaxaca2")]
  }

  agregarCliente(){
    $("#nuevo").modal({
      backdrop: 'static'
    });
    $("#nuevo").modal("show")
  }



}
