import { Component, OnInit } from '@angular/core';
import {Factura} from 'src/app/_models/factura'
import {FacturaService} from 'src/app/_services/factura.service'
import {Producto } from '../../_models/producto'
import {Region} from '../../_models/region'
import {Cliente} from '../../_models/cliente'

import { FormBuilder, Validators, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

    

  }

}
