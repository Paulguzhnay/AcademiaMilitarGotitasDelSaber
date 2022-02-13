import { Component, OnInit,Input } from '@angular/core';
import { Historial } from 'src/app/domain/historial';
import { HistoriaAcademicawsService } from '../services/historia-academicaws.service';

@Component({
  selector: 'app-historial-academico',
  templateUrl: './historial-academico.component.html',
  styleUrls: ['./historial-academico.component.scss']
})
export class HistorialAcademicoComponent implements OnInit {
  Cedula: string ="";
  historialGrupo:Historial=new Historial;
  constructor(private historialService: HistoriaAcademicawsService ) { }
 
  @Input() dep:any;
  

  ngOnInit(): void {
   
    
    console.log("ngOnInit")
  }

  historial:any


  cargarHistorial(){
    
    console.log("hola",this.Cedula)
    this.historial= this.historialService.getHistoria(this.Cedula);
    
  }
}
