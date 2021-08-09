import { Component, OnInit } from '@angular/core';
import { Region } from 'src/app/_models/region';
import { ClienteService } from 'src/app/_services/cliente.service';
import {Cliente} from '../../_models/cliente'
import {RegionService} from 'src/app/_services/region.service'
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

declare var $:any;

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  clientes : Cliente [] | any 
  regiones : Region [] | any
  clienteForm : FormGroup | any
  submitted = false

  constructor(
    private clienteService: ClienteService , 
    private regionService: RegionService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {


  this.clienteForm = this.formBuilder.group({ 
      id : [''],
      nombres : ['', Validators.required],
      apellidos: ['', Validators.required],
      rfc: ['', Validators.required],
      correo: ['', Validators.required],
      region: ['', Validators.required]
    })
    this.getClientes()
    this.getRegiones()


  }


  getClientes(){
    this.clientes = []
    this.clienteService.getClientes().subscribe(
    res => {
      this.clientes = res
      console.log(JSON.stringify(this.clientes))
      },
      err => {
        console.log(err)
      }
    )
    
  }

  getRegiones(){

    this.regiones = []
    this.regionService.getRegiones().subscribe(
      res=>{
        this.regiones = res
        console.log(res)
      },
      err=>{
        console.error(err)
      }

    )
  }

  agregarCliente(){
    this.clienteForm.reset()
    
    $("#nuevo").modal("show")
  }

  buscaRegion(region: String){
    for (let i of this.regiones){
      if (region == i.region){
        return i
      }
    }
  }
  createCliente(){
    console.log(JSON.stringify( this.clienteForm.value));
    this.submitted = true
    if(this.clienteForm.invalid){
      this.showFail("hacen falta datos \n\n 😢")
      return
    }
    const newCliente =  new Cliente(null,
                              this.clienteForm.value.nombres, 
                              this.clienteForm.value.apellidos, 
                              this.clienteForm.value.rfc, 
                              this.clienteForm.value.correo,
                              this.buscaRegion(this.clienteForm.value.region))
                              
    this.clienteService.createCliente(newCliente).subscribe(
      res =>{
        this.submitted=false
        $("#nuevo").modal("hide")
        this.showSucces("Agregado! \n\n 😎")
        this.getClientes()
      },
      err => {    
        this.showFail("No se pudo agregar \n\n 😢")
      }
    )   
    
  }




  get f () {return this.clienteForm.controls}

  showFail(message){
    Swal.fire({
      icon: 'error',
      title: message
      
    });
  }

  showSucces(message){
    Swal.fire({
      icon: 'success',
      title: message,
    });
  }
}
