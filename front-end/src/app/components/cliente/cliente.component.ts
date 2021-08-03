import { Component, OnInit } from '@angular/core';
import { Region } from 'src/app/_models/region';
import { ClienteService } from 'src/app/_services/cliente.service';
import {Cliente} from '../../_models/cliente'
import {RegionService} from 'src/app/_services/region.service'
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

declare var $:any;

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clientes : Cliente [] | any 
  regiones : Region [] | any
  clienteForm : FormGroup
  summited = false

  constructor(
    private clienteService: ClienteService , 
    private regionService: RegionService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {

  this.clienteForm = this.formBuilder.group(
    {
      id: [''],
      nombres: ['', Validators.required],
      apellidos : ['', Validators.required],
      rfc: ['', Validators.required],
      correo : ['', Validators.required],
      id_region : ['', Validators.required]
    }
  )

  this.getClientes()
  this.getRegiones()

  }



  getClientes(){

    this.clientes = [new Cliente(1,"nombre", "apellido", "rfc1", "correo", 1),new Cliente(1,"nombre", "apellido", "rfc2", "correo", 2)]
//    this.clienteService.getClientes().subscribe(
//    res => {
//      this.clientes = res
//      console.log(res)
//      },
//      err => {
//        console.log(err)
//      }
//)
    
  }

  getRegiones(){
    this.regiones = [new Region(1, "oaxaca"),new Region(2, "oaxaca2")]
//    this.regionService.getRegiones().subscribe(
//      res=>{
//        this.regiones = res
//      },
//      err=>{
//        console.error(err)
//      }
//
//    )
  }

  agregarCliente(){
    $("#nuevo").modal({
      backdrop: 'static'
    });
    $("#nuevo").modal("show")
  }


  createCliente(){
    
  }


}
