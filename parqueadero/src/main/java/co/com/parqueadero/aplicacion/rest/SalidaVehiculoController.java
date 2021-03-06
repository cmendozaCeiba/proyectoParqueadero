package co.com.parqueadero.aplicacion.rest;

import java.time.LocalDateTime;

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
import co.com.parqueadero.persistencia.convertidor.ParqueaderoEntityAParqueaderoApi;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@CrossOrigin(origins ="*")
@RestController
public class SalidaVehiculoController {

	@Autowired
	VehiculoMetodoFactoria vehiculoFactoria;
	
	@Autowired
	private ParqueaderoEntityAParqueaderoApi parqueaderoEntityAParqueaderoApi;
	
	 Vigilante vigilante = new Vigilante();
	
	@RequestMapping(value="/salidaVehiculo", 
				method=RequestMethod.PATCH)
	public ResponseEntity<?> salidaVehiculo(@RequestBody ParqueaderoApi parqueaderoApi){
		
		Vehiculo vehiculoSalida = vehiculoFactoria.crearVehiculo(parqueaderoApi);
		vehiculoSalida.setFechaSalida(LocalDateTime.now());
		ParqueaderoEntity parquaederoEntity = vigilante.salidaVehiculo(vehiculoSalida);
		
		return new ResponseEntity<>(parqueaderoEntityAParqueaderoApi.convert(parquaederoEntity), HttpStatus.OK);
	}
}
