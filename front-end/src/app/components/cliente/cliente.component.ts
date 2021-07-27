import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ClienteService } from 'src/app/_services/cliente.service';
import {Cliente} from '../../_models/cliente'

declare var $: any

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clientes : Cliente [] | any 

  constructor(private clienteService: ClienteService , private formBuilder: FormBuilder) { }

  ngOnInit(): void {

  this.getClientes()

  }

  getClientes(){

    this.clientes = [new Cliente(1,"nombre", "apellido", "rfc", "correo", 23)]
    console.log("get Clientes")
    
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


}
