import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HistorialAcademicoComponent } from './pages/historial-academico/historial-academico.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { VentanaPrincipalComponent } from './pages/ventana-principal/ventana-principal.component';


@NgModule({
  declarations: [
    AppComponent,
    HistorialAcademicoComponent,
    VentanaPrincipalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
