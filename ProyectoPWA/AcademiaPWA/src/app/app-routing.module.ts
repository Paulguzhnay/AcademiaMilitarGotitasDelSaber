import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibroDiarioComponent } from './pages/libro-diario/libro-diario.component';

const routes: Routes = [
  {path: "libroDiario", component: LibroDiarioComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
