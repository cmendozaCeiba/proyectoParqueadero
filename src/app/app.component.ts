import { Component, OnInit } from '@angular/core';
import { ParqueaderoService } from './app.parqueadero.service';
import { Parqueadero } from './app.parqueadero';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';

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
  private formGroup: FormGroup;
  private post: any;
  alert: boolean;


  constructor(private parqueaderoService: ParqueaderoService,
              private formBuilder: FormBuilder
  ){
    this.formGroup = formBuilder.group({
      'placa': [null, Validators.required],
      'cilindraje':''
    });
  }

  ngOnInit(){
    this.obtenerParqueos();
  }

  obtenerParqueos(){
    this.parqueaderoService.obtenerParqueos().subscribe(parqueos => {
      this.parqueos = parqueos;
    },
    error => {
      console.error(error);
    });
  }

  public guardarIngreso(post){
    this.setData(post);
    console.log(this.parqueoAgregar);
    this.parqueaderoService.crearParqueo(this.parqueoAgregar)
    .subscribe(data => console.log(data), error => console.log(error));
    this.alert = true;
  }

  setData(data){
    this.parqueoAgregar.placa = data.placa;
    this.parqueoAgregar.cilindraje =  data.cilindraje;
    console.log(data);
  }

  public salidaVehiculo(parqueoSalida: Parqueadero){
    console.log(parqueoSalida);
    this.parqueaderoService.salidaParqueo(parqueoSalida)
    .subscribe(data => console.log(data), error => console.log(error));
  }

}
