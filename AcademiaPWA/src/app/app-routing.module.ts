import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HistorialAcademicoComponent } from './pages/historial-academico/historial-academico.component';
import { VentanaPrincipalComponent } from './pages/ventana-principal/ventana-principal.component';

const routes: Routes = [
  {path:"Historial",component:HistorialAcademicoComponent},
  {path:"Main",component:VentanaPrincipalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
