import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { libroDiario } from 'src/app/domain/libro-Diario';
@Injectable({
  providedIn: 'root'
})
export class ContactowsService {

  constructor(private http: HttpClient) { }
  
  libro:libroDiario = new libroDiario();

  getLibro(fecha:string):Observable<any[]>{
    let url="http://localhost:8080/AcademiaMilitar/rs/academia?fecha="+fecha;
    return this.http.get<any>(url);
  }
}
