package co.com.parqueadero.aplicacion.rest.unitaria;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.parqueadero.aplicacion.rest.IngresoVehiculoController;
import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.ParqueaderoApi;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.factoria.VehiculoMetodoFactoria;

@RunWith(SpringRunner.class)
public class IngresarVehiculoControllerTest {

	@Mock
	private VehiculoMetodoFactoria vehiculoFactoria;
	
	@InjectMocks
	private IngresoVehiculoController ingresarVehiculoController;
	
	@Test
	public void ingresarVehiculoTest() {
		Vehiculo vehiculo = new Carro("ert", 0.0, LocalDateTime.now(),null );
		when(vehiculoFactoria.crearVehiculo(any(ParqueaderoApi.class))).thenReturn(vehiculo);
		
		ResponseEntity<?> respuesta = ingresarVehiculoController.ingresarVehiculo(any(ParqueaderoApi.class));
		
		Assert.assertNotNull(respuesta);
		Assert.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		
		
	}
	
}
