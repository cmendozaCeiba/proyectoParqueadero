import { Http, Response } from "@angular/http"
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import { Parqueadero } from "./app.parqueadero";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class ParqueaderoService{

    private url: string = "http://localhost:8081";

    constructor(private http: Http){
    }

    obtenerParqueos(): Observable<Parqueadero[]> {
        return this.http.get(this.url+'/listarVehiculos')
        .map((res:Response) => res.json())
        .catch((error:any) => Observable.throw(error.json().error));
    }

    crearParqueo(parqueadero: Parqueadero): Observable<Object>{
        return this.http.post(this.url+'/ingresarVehiculo', parqueadero);
    }

    private handleError (error: Response | any) {
        console.error('ApiService::handleError', error);
        return Observable.throw(error);
      }

}