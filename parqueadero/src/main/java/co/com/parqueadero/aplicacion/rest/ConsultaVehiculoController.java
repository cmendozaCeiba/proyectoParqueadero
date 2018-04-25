package co.com.parqueadero.aplicacion.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;
import co.com.parqueadero.persistencia.repositorio.RepositorioParqueaderoPersistente;

@RestController
public class ConsultaVehiculoController {

	RepositorioParqueadero repositorioParqueadero = new RepositorioParqueaderoPersistente();
	
	@RequestMapping(value="/listarVehiculos", 
				method=RequestMethod.GET)
	public ResponseEntity<?> listarVehiculos() {
		
		List<ParqueaderoEntity> parqueos = repositorioParqueadero.listarParqueos();
		return new ResponseEntity<List<ParqueaderoEntity>>(parqueos, HttpStatus.OK);
	}
	
}
