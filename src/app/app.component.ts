import { Component, OnInit } from '@angular/core';
import { ParqueaderoService } from './app.parqueadero.service';
import { Parqueadero } from './app.parqueadero';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ParqueaderoService]
})

export class AppComponent implements OnInit{
  title = 'Parqueadero';

  private parqueos: Parqueadero[];
  parqueoAgregar = new Parqueadero();


  constructor(private parqueaderoService: ParqueaderoService){}

  ngOnInit(){
    this.obtenerParqueos();
  }

  obtenerParqueos(){
    this.parqueaderoService.obtenerParqueos().subscribe(parqueos => {
      this.parqueos = parqueos;
    },
    error => {
      console.error();
    });
  }

  public guardarIngreso(event){
    this.parqueaderoService.crearParqueo(this.parqueoAgregar)
    .subscribe(data => console.log(data), error => console.log(error));
  }

  public salidaVehiculo(parqueoSalida: Parqueadero){
    console.log(parqueoSalida);
    this.parqueaderoService.salidaParqueo(parqueoSalida)
    .subscribe(data => console.log(data), error => console.log(error));
  }

}
