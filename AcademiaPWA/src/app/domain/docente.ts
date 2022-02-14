import { Persona } from "./persona";

export class Docente{
    id?: number;
    titulo: string='';
    gradoTiulo: string='';
    especializacion: string='';
    persona: Persona = new Persona;
}