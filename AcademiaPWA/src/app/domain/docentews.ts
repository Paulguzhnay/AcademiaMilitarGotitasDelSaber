import { PersonaWS } from "./personaws";


export class DocenteWS{
    id?: number;
    titulo: string='';
    gradoTiulo: string='';
    especializacion: string='';
    persona: PersonaWS = new PersonaWS;
}