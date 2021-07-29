import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormBuilder } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FacturaComponent } from './components/factura/factura.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { RegionComponent } from './components/region/region.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProductosComponent } from './components/productos/productos.component';
import { ArticulosComponent } from './components/articulos/articulos.component';
import { CategoriasComponent } from './components/categorias/categorias.component';
import { IncorrectoComponent } from './components/incorrecto/incorrecto.component';
import { AboutComponent } from './components/about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    FacturaComponent,
    ClienteComponent,
    RegionComponent,
    FooterComponent,
    NavbarComponent,
    ProductosComponent,
    ArticulosComponent,
    CategoriasComponent,
    IncorrectoComponent,
    AboutComponent
  ],
  exports: [
    FacturaComponent,
    ClienteComponent,
    RegionComponent,
    ProductosComponent,
    ArticulosComponent,
    CategoriasComponent,
    IncorrectoComponent, 
    FooterComponent,
    NavbarComponent

  ],

  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [ FormBuilder],
  bootstrap: [AppComponent]
})
export class AppModule { }
