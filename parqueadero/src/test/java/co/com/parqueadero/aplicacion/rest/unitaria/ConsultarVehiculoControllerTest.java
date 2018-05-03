package co.com.parqueadero.aplicacion.rest.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.parqueadero.aplicacion.rest.ConsultaVehiculoController;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.convertidor.ListaParqueaderoEntityAListaParqueaderoApi;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@RunWith(SpringRunner.class)
public class ConsultarVehiculoControllerTest {
	
	@Mock
	private RepositorioParqueadero repositorioParqueadero;
	
	@Mock
	private ListaParqueaderoEntityAListaParqueaderoApi parqueaderoEntityAParqueaderoApi;
	
	@InjectMocks
	private ConsultaVehiculoController consultarVehiculoController;
	
	
	@Test
	public void consultarVehiculosTest() throws Exception {
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity(LocalDateTime.of(2018,04,28, 10,15),"Carro", null, 0.0, "I", "FRE378");
		List<ParqueaderoEntity> parqueos = new ArrayList<>();
		parqueos.add(parqueaderoEntity);
		
		when(repositorioParqueadero.listarParqueos()).thenReturn(parqueos);
		
		ResponseEntity<?> listarVehiculos = consultarVehiculoController.listarVehiculos();
		
		verify(repositorioParqueadero, atLeast(1)).listarParqueos();
		
		assertNotNull(listarVehiculos.getBody());
		assertEquals(listarVehiculos.getStatusCode(), HttpStatus.OK);
	}
}
