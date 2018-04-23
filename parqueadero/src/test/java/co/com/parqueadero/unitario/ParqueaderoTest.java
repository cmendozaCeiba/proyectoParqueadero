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
	private static final String PLACA_GUARDAR = "HFR1231";
	private static final String ESTADO_INGRESO = "I";

	RepositorioParqueadero repositorioParqueo = new RepositorioParqueaderoPersistente();
	
	@Test
	public void guardarParqueoMoto() {
		// arrange
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity(new Date(),TIPO_VEHICULO_MOTO, null, 0.0, ESTADO_INGRESO, PLACA_GUARDAR);
		
		// act
		repositorioParqueo.guardarIngresoParqueo(parqueaderoEntity);
		
		// Assert
		Assert.assertTrue(repositorioParqueo.existeParqueo(parqueaderoEntity));
	}
	
	@Test
	public void guardarSalidaParqueo() {
		ParqueaderoEntity parqueaderoGuardarEntity = new ParqueaderoEntity(new Date(),TIPO_VEHICULO_MOTO, null, 0.0, ESTADO_INGRESO, PLACA);
		
		// act
		repositorioParqueo.guardarIngresoParqueo(parqueaderoGuardarEntity);
		
		ParqueaderoEntity parqueaderoEntity = repositorioParqueo.consultarParqueoPorPlaca(PLACA);
		parqueaderoEntity.setFechaSalida(new Date());
		parqueaderoEntity.setEstado("S");
		parqueaderoEntity.setMontoCobrado(5000.0);
		
		repositorioParqueo.guardarSalidaParqueo(parqueaderoEntity);
		double actual = repositorioParqueo.consultarParqueoPorPlaca(PLACA).getMontoCobrado();
		Assert.assertEquals(5000.0, actual,0);
	}
}
