package co.com.parqueadero.aplicacion.rest;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.dominio.factoria.VehiculoMetodoFactoria;

@CrossOrigin(origins ="*")
@RestController
public class IngresoVehiculoController {
	
	@Autowired
	VehiculoMetodoFactoria vehiculoFactoria;
	
	 Vigilante vigilante = new Vigilante();
	
	@RequestMapping(value="/ingresarVehiculo",
			consumes="application/json",
			method = RequestMethod.POST)
	public ResponseEntity<?> ingresarVehiculo(@RequestBody String json) {
		
		Gson gson = new Gson();
		Properties properties  = gson.fromJson(json, Properties.class);
		Vehiculo vehiculo = gson.fromJson(json, Vehiculo.class);
		
		vehiculo = vehiculoFactoria.crearVehiculo(properties.getProperty("cilindraje"), vehiculo);
		
		vigilante.ingresarVehiculo(vehiculo);
		
		return new ResponseEntity<>(vehiculo, HttpStatus.OK);
	}
}
