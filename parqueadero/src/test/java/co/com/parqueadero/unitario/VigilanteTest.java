package co.com.parqueadero.unitario;

import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import co.com.parqueadero.constante.Constante;
import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.exception.ParqueaderoException;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@RunWith(MockitoJUnitRunner.class)
public class VigilanteTest {

	@Mock
	private RepositorioParqueadero repositorioParqueadero;
	
	@Mock
	private Vigilante vigilante;
	
	private static final String PLACA = "sdd215";
	private static final int CILINDRAJE = 800;
	
	@Test
	public void ingresarVehiculoMotoMayorCapacidadTest() {
			
			ParqueaderoEntity parqueaderoEntity =  mock(ParqueaderoEntity.class);
		
			when(repositorioParqueadero.consultarParqueoPorPlaca(PLACA)).thenReturn(parqueaderoEntity);
			
//				Vehiculo vehiculo = new Moto(PLACA, CILINDRAJE,0.0, LocalDateTime.now(), null);
//				
//				vigilante.ingresarVehiculo(vehiculo);
//			
			Assert.assertFalse(repositorioParqueadero.existeParqueo(parqueaderoEntity));
			
//			Assert.assertEquals(Constante.MENSAJE_PARQUEADERO_LLENO_MOTO, pe.getMessage());
	}
	
	
	@Test
	public void ingresarVehiculoCarroMayorCapacidadTest() {
		try {

			for(int i=0;i<21;i++) {
				Vehiculo vehiculo = new Carro(PLACA, 0.0, LocalDateTime.now(), null);
				
				vigilante.ingresarVehiculo(vehiculo);
			}
			
			fail();
			
		}catch(ParqueaderoException pe) {
			Assert.assertEquals(Constante.MENSAJE_PARQUEADERO_LLENO_CARRO, pe.getMessage());
		}
	}
}
