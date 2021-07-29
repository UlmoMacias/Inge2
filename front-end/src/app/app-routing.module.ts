import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { ArticulosComponent } from './components/articulos/articulos.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import {FacturaComponent} from './components/factura/factura.component'
import { FooterComponent } from './components/footer/footer.component';
import { IncorrectoComponent } from './components/incorrecto/incorrecto.component';

const routes: Routes = [
  
  { path: '' , component: ClienteComponent},
  { path: 'about', component: AboutComponent},
  { path: 'clientes', component: ClienteComponent},
  { path: 'clientes/facturas' , component:FacturaComponent},
  { path: 'clientes/facturas/nueva', component: ArticulosComponent},
  { path: '**', component: IncorrectoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
