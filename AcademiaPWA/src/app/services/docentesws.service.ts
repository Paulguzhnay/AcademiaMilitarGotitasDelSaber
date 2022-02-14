import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocenteswsService {

  constructor(private http: HttpClient) { }

  getDocentes(){
    let url ="http://localhost:8080/AcademiaMilitar/rs/docentes";
    return this.http.get<any>(url);
  }

}
