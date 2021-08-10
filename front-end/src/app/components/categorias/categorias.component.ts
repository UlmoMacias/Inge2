import { Component, OnInit } from '@angular/core';
import {Categoria} from 'src/app/_models/categoria'
import { CategoriasService } from 'src/app/_services/categorias.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';
declare var $: any
@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  categoriaForm : FormGroup
  submitted = false
  constructor(
    private formBuilder: FormBuilder ,
    private categoriasService: CategoriasService
  ) { }

  ngOnInit(): void {

    this.categoriaForm = this.formBuilder.group({
      categoria : ['', Validators.required]
    })

  }


  crearCategoria(){

    this.submitted = true
    if(this.categoriaForm.invalid){
      this.showFail("hacen falta datos \n\n 😢")
      return
    }

    const categoria = new Categoria(null, this.categoriaForm.value.categoria)

    this.categoriasService.createCategoria(categoria).subscribe(
      res => {
        this.submitted=false
        this.categoriaForm.reset()
        this.showSucces("Categoria creada!")
      },
      err => {
          this.showFail("No se puede crear la categoria")
      }
    )
    
  }

  get f () {return this.categoriaForm.controls}

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
