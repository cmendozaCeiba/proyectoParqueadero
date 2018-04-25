package co.com.parqueadero.aplicacion.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.repositorio.RepositorioParqueaderoPersistente;

@RestController
public class ConsultaVehiculoController {

	RepositorioParqueadero repositorioParqueadero = new RepositorioParqueaderoPersistente();
	
	@RequestMapping(value="/listarVehiculos", 
				produces="aplication/json",
				method=RequestMethod.GET)
	public void listarVehiculos() {
		repositorioParqueadero.listarParqueos();
	}
	
}
