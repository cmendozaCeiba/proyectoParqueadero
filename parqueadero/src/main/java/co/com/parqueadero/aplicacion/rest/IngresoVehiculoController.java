package co.com.parqueadero.aplicacion.rest;

import java.time.LocalDateTime;
import java.util.Properties;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.dominio.factoria.VehiculoFactoria;
import co.com.parqueadero.dominio.factoria.VehiculoMetodoFactoria;

@RestController
public class IngresoVehiculoController {
	
	 VehiculoMetodoFactoria vehiculoFactoria = new VehiculoFactoria();
	 Vigilante vigilante = new Vigilante();
	
	@RequestMapping(value="/ingresarVehiculo",
			consumes="application/json",
			method = RequestMethod.POST)
	public void ingresarVehiculo(@RequestBody String json) {
		
		Gson gson = new Gson();
		Properties properties  = gson.fromJson(json, Properties.class);
		Vehiculo vehiculo = gson.fromJson(json, Vehiculo.class);
		
		vehiculo = vehiculoFactoria.crearVehiculo(properties.getProperty("cilindraje"), vehiculo);
		vehiculo.setFechaIngreso(LocalDateTime.now());
		
		vigilante.ingresarVehiculo(vehiculo);
	}
}
