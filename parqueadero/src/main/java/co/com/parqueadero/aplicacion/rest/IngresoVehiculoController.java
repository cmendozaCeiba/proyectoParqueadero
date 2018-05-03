package co.com.parqueadero.aplicacion.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueadero.dominio.ParqueaderoApi;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.dominio.factoria.VehiculoMetodoFactoria;

@CrossOrigin(origins ="*")
@RestController
public class IngresoVehiculoController {
	
	@Autowired
	private VehiculoMetodoFactoria vehiculoFactoria;
	
	 Vigilante vigilante = new Vigilante();
	
	@RequestMapping(value="/ingresarVehiculo",
			consumes="application/json",
			method = RequestMethod.POST)
	public ResponseEntity<?> ingresarVehiculo(@RequestBody ParqueaderoApi parqueaderoApi) {
		
		Vehiculo vehiculo = vehiculoFactoria.crearVehiculo(parqueaderoApi);
		vigilante.ingresarVehiculo(vehiculo);
		
		return new ResponseEntity<>(vehiculo, HttpStatus.OK);
	}
}
