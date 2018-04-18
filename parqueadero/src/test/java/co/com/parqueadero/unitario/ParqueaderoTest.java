package co.com.parqueadero.unitario;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;

import java.util.Date;

import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

public class ParqueaderoTest {
	
	private static final String TIPO_VEHICULO_MOTO = "Moto";
	private static final String PLACA = "HFR123";
	private static final String ESTADO_INGRESO = "I";

	
	@Test
	public void guardarParqueoMoto() {
		//
		RepositorioParqueadero repositorioParqueo = mock(RepositorioParqueadero.class);
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity(new Date(),TIPO_VEHICULO_MOTO, null, 0.0, ESTADO_INGRESO, PLACA);
		
		repositorioParqueo.guardarIngresoParqueo(parqueaderoEntity);
		
		Assert.assertTrue(repositorioParqueo.existeParqueo(parqueaderoEntity));
	}
}
