package co.com.parqueadero.aplicacion.rest.unitaria;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import co.com.parqueadero.aplicacion.rest.ConsultaVehiculoController;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;

public class ConsultarVehiculoControllerTest {

	private ConsultaVehiculoController consultarVehiculoController;
	 
	private RepositorioParqueadero repositorioParqueadero;
	
	@Before
	public void init() {
		repositorioParqueadero = mock(RepositorioParqueadero.class);
		
		consultarVehiculoController =  mock(ConsultaVehiculoController.class);
	}
	
	@Test
	public void consultarVehiculo() {
		
	}
	
}
