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

import co.com.parqueadero.aplicacion.rest.SalidaVehiculoController;
import co.com.parqueadero.databuilder.ParqueaderoEntityBuilder;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.ParqueaderoApi;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.dominio.factoria.VehiculoMetodoFactoria;
import co.com.parqueadero.persistencia.convertidor.ParqueaderoEntityAParqueaderoApi;

@RunWith(SpringRunner.class)
public class SalidaVehiculoControllerTest {

	@Mock
	private VehiculoMetodoFactoria vehiculoFactoria;
	@Mock
	private Vigilante vigilante;
	@Mock
	private ParqueaderoEntityAParqueaderoApi parqueaderoEntityAParqueaderoApi;
	
	@InjectMocks
	private SalidaVehiculoController salidaVehiculoController;
	
	@Test
	public void salidaVehiculo() {
		Vehiculo moto = new Moto("POR7", 0.0, 900, LocalDateTime.of(2018, 05,20,10,00), null);
		when(vehiculoFactoria.crearVehiculo(any(ParqueaderoApi.class))).thenReturn(moto);
		when(vigilante.salidaVehiculo(moto)).thenReturn(new ParqueaderoEntityBuilder().build());
		
		ResponseEntity<?> respuesta = salidaVehiculoController.salidaVehiculo(any(ParqueaderoApi.class));
		
		Assert.assertNotNull(respuesta);
		Assert.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		
	}
	
}
