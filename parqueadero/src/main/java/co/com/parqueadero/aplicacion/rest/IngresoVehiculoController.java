package co.com.parqueadero.aplicacion.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.factoria.VehiculoFactoria;
import co.com.parqueadero.dominio.factoria.VehiculoMetodoFactoria;

@RestController
public class IngresoVehiculoController {
	
	 VehiculoMetodoFactoria vehiculoFactoria = new VehiculoFactoria();
	
	@RequestMapping(value="/ingresarVehiculo",
			consumes="application/json",
			method = RequestMethod.POST)
	public void ingresarVehiculo(@RequestBody String json) {
		
		Vehiculo vehiculo = new Gson().fromJson(json, Vehiculo.class);
		vehiculo = vehiculoFactoria.crearVehiculo(vehiculo.get)
		vehiculo.setFechaIngreso(LocalDateTime.now());
		
	}
}
