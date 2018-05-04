package co.com.parqueadero.unitario;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.parqueadero.databuilder.ParqueaderoEntityBuilder;
import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.convertidor.VehiculoAParqueaderoEntity;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@RunWith(SpringRunner.class)
public class VigilanteTest {

	private static final String PLACA = "SRT05A";
	
	@Mock
	private RepositorioParqueadero repositorioParqueadero;
	@Mock
	private VehiculoAParqueaderoEntity vehiculoAParqueaderoEntity;
	@Mock
	private Parqueadero parqueadero;
	@Mock
	private ParqueaderoEntity parqueaderoEntity;
	
	@InjectMocks
	private Vigilante vigilante;
	
	@Test
	public void ingresarVehiculoTest() {
		ParqueaderoEntityBuilder parqueaderoEntityBuilder =  new ParqueaderoEntityBuilder();
		ParqueaderoEntity parqueaderoEntity = parqueaderoEntityBuilder.build();
			
			when(repositorioParqueadero.guardarIngresoParqueo(any(ParqueaderoEntity.class))).thenReturn(parqueaderoEntity);
			
			Vehiculo vehiculo = new Carro("rtu",0.0, LocalDateTime.now(), null);
			
			ParqueaderoEntity parqueaderoRecibido = vigilante.ingresarVehiculo(vehiculo);
				
			verify(repositorioParqueadero, atLeast(1)).guardarIngresoParqueo(any(ParqueaderoEntity.class));
				
			Assert.assertNotNull(parqueaderoRecibido);
			Assert.assertEquals("Carro", parqueaderoRecibido.getTipoVehiculo());
			
	}
	
	
	@Test
	public void salidaVehiculo() {
		ParqueaderoEntityBuilder parqueaderoEntityBuilder =  new ParqueaderoEntityBuilder();
		ParqueaderoEntity parqueaderoEntity = parqueaderoEntityBuilder.build(); // new ParqueaderoEntity(LocalDateTime.now(), "Carro", null, 0, "I","rtu");
		
		when(repositorioParqueadero.consultarParqueoPorPlaca(any())).thenReturn(parqueaderoEntity);
		
		when(repositorioParqueadero.guardarSalidaParqueo(any(ParqueaderoEntity.class))).thenReturn(parqueaderoEntity);
		
		Vehiculo vehiculo = new Carro("rtu",0.0, LocalDateTime.now(), LocalDateTime.now());
		
		ParqueaderoEntity parqueo = vigilante.salidaVehiculo(vehiculo);
		
		Assert.assertNotNull(parqueo);
		Assert.assertEquals(PLACA, parqueo.getPlaca());
		
	}
}
