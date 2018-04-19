package co.com.parqueadero.unitario;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;
import co.com.parqueadero.persistencia.repositorio.RepositorioParqueaderoPersistente;

public class ParqueaderoTest {
	
	private static final String TIPO_VEHICULO_MOTO = "Moto";
	private static final String PLACA = "HFR123";
	private static final String ESTADO_INGRESO = "I";

	
	@Test
	public void guardarParqueoMoto() {
		// arrange
		RepositorioParqueadero repositorioParqueo = new RepositorioParqueaderoPersistente();
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity(new Date(),TIPO_VEHICULO_MOTO, null, 0.0, ESTADO_INGRESO, PLACA);
		
		// act
		repositorioParqueo.guardarIngresoParqueo(parqueaderoEntity);
		
		// Assert
		Assert.assertTrue(repositorioParqueo.existeParqueo(parqueaderoEntity));
	}
}
