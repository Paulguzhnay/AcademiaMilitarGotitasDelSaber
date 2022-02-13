import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { libroDiario } from 'src/app/domain/libro-Diario';
import { LibroWS } from 'src/app/domain/libro-DiarioWS';
import { ContactowsService } from 'src/app/service/contactows.service';

@Component({
  selector: 'app-libro-diario',
  templateUrl: './libro-diario.component.html',
  styleUrls: ['./libro-diario.component.css']
})
export class LibroDiarioComponent implements OnInit {


  libro: LibroWS = new LibroWS();
  libros:any;
  constructor(private contactoService: ContactowsService) { }

  ngOnInit(): void {
  }


  cargarLibro(fecha:string){
    
    this.libros=this.contactoService.getLibro(fecha);
    console.log(this.libros)
  }
}
