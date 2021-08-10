import { Component, OnInit } from '@angular/core';
import {Producto} from 'src/app/_models/producto'
import {ProductosService} from 'src/app/_services/productos.service'
import {CategoriasService} from 'src/app/_services/categorias.service'
import {Categoria} from 'src/app/_models/categoria'
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import Swal from 'sweetalert2';

declare var $: any
@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  productoForm : FormGroup 
  categorias : Categoria [] | any 
  submitted = false


  constructor(
    private productosService: ProductosService, 
    private categoriasService: CategoriasService,
    private formBuilder: FormBuilder  

  ) { }

  ngOnInit(): void {

    this.productoForm = this.formBuilder.group({
      codigo : ['',Validators.required],
      nombre : ['', Validators.required],
      descripcion: ['',Validators.required],
      cantidad : ['',Validators.required],
      precio: ['', Validators.required],
      categorias: ['',Validators.required]
    }
      

    )

    this.getCategorias()

  }

  getCategorias(){
    this.categorias = []
    this.categoriasService.getCategorias().subscribe(
      res => {
        this.categorias = res
        console.log(this.categorias)
      },
      err => {

      }
    )
  }

  buscaRegion(categoria: String){
    for (let i of this.categorias){
      if (categoria == i.categoria){
        return i
      }
    }
  }


  buscaCategoria(categoria: String){
    for (let i of this.categorias){
      if (categoria == i.categoria){
        return i
      }
    }
  }

  crearProducto(){
    this.submitted = true
    if(this.productoForm.invalid){
      this.showFail("hacen falta datos \n\n 😢")
      return
    }

    console.log()

    var today = new Date();
      today.setDate(today.getDate() + 1);
      var dd = String(today.getDate()).padStart(2, '0');
      var mm = String(today.getMonth() + 1).padStart(2, '0');
      var yyyy = String(today.getFullYear());
      
      const hoy = yyyy + '-' + mm + '-' + dd;
    const producto = new Producto(null, 
      this.productoForm.value.codigo, 
      this.productoForm.value.nombre, 
      this.productoForm.value.descripcion, 
      this.productoForm.value.cantidad, 
      this.productoForm.value.precio,
      new Date( hoy ), 
      this.buscaCategoria(this.productoForm.value.categorias))
  
      this.productosService.createProducto(producto).subscribe(
        res => {
          this.submitted=false
          this.productoForm.reset()
          this.showSucces("Creado!")
          

        },
        err => {

        }
      )

      console.log(producto)

  }
  


  get f () {return this.productoForm.controls}

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
