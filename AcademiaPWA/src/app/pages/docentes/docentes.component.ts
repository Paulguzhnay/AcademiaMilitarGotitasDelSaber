import { Component, OnInit } from '@angular/core';
import { DocenteWS } from 'src/app/domain/docentews';
import { DocenteswsService } from 'src/app/services/docentesws.service';

@Component({
  selector: 'app-docentes',
  templateUrl: './docentes.component.html',
  styleUrls: ['./docentes.component.css']
})
export class DocentesComponent implements OnInit {

  docente: DocenteWS = new DocenteWS();

  docentes: any;

  

  constructor(private docenteService: DocenteswsService) { }

  ngOnInit(): void {
    this.cargarDocentes();
  }

  cargarDocentes(){
    this.docentes = this.docenteService.getDocentes();
  }

  docente1: DocenteWS = new DocenteWS();;

  mostrarInformacion(docenteI: DocenteWS){
    this.docente1 = docenteI;
    console.log(this.docente1)
  }
}
