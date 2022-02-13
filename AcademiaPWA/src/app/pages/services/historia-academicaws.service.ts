import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HistoriaAcademicawsService {

  constructor(private http: HttpClient) { }

  getHistoria(user: string){

     let uri="http://localhost:8080/AcademiaMilitar/rs/historialAcademico?cedula="
    let url=uri+user
    console.log(url)
    return this.http.get<any>(url);
  }
}
