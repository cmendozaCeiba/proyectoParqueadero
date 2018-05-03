package co.com.parqueadero.aplicacion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.builder.ConvertirParqueaderEntityAVehiculo;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@CrossOrigin(origins ="*")
@RestController
public class ConsultaVehiculoController {

	@Autowired
	RepositorioParqueadero repositorioParqueadero;

	@Autowired
	private ConvertirParqueaderEntityAVehiculo convertirParqueaderoEntityAVehiculo;
	
	@RequestMapping(value="/listarVehiculos", 
				method=RequestMethod.GET)
	public ResponseEntity<?> listarVehiculos() {
		
		List<ParqueaderoEntity> parqueos = repositorioParqueadero.listarParqueos();
		return new ResponseEntity<List<Vehiculo>>(convertirParqueaderoEntityAVehiculo.convert(parqueos), HttpStatus.OK);
	}
}
