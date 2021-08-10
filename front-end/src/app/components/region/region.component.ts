import { Component, OnInit } from '@angular/core';
import {Region} from 'src/app/_models/region'
import { RegionService} from 'src/app/_services/region.service'
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';
declare var $: any

@Component({
  selector: 'app-region',
  templateUrl: './region.component.html',
  styleUrls: ['./region.component.css']
})
export class RegionComponent implements OnInit {

  regionForm : FormGroup
  submitted = false

  constructor(
    private regionService: RegionService ,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.regionForm = this.formBuilder.group(
      { 
        region : ['', Validators.required]
      }
    )
  }

  crearRegion(){
    this.submitted = true
    if(this.regionForm.invalid){
      this.showFail("hacen falta datos \n\n 😢")
      return
    }

    const region = new Region(null, this.regionForm.value.region)
    this.regionService.createRegion(region).subscribe(
      res => {
        this.submitted=false
        this.regionForm.reset()
        this.showSucces("Categoria creada!")
      },
      err => {
        this.showFail("No se puede crear la region")
      }
    )
  }

  

  
  get f () {return this.regionForm.controls}

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
