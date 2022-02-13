import { Docente } from "./docente";
import { Materia } from "./materia";


export class Historial{
    id:number=0;
    numeroGrupo:number=0;
    nivel:number=0;
    materia:Materia=new Materia;
    docente:Docente=new Docente;
}