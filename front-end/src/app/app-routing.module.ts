import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteComponent } from './components/cliente/cliente.component';
import {FacturaComponent} from './components/factura/factura.component'
import { FooterComponent } from './components/footer/footer.component';
import { IncorrectoComponent } from './components/incorrecto/incorrecto.component';

const routes: Routes = [
  
  { path: '' , component: ClienteComponent},
  { path: 'clientes', component: ClienteComponent},
  { path: '**', component: IncorrectoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
