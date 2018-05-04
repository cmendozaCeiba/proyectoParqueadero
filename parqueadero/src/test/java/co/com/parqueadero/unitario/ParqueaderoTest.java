package co.com.parqueadero.unitario;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import co.com.parqueadero.databuilder.ParqueaderoEntityBuilder;
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
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntityBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO).build();
		
		// act
		ParqueaderoEntity parqueo = repositorioParqueo.guardarIngresoParqueo(parqueaderoEntity);
		
		// Assert
		Assert.assertNotNull(parqueo);
		Assert.assertEquals(TIPO_VEHICULO_MOTO, parqueo.getTipoVehiculo());
	}
	
	@Test
	public void guardarSalidaParqueo() {
		ParqueaderoEntity parqueaderoGuardarEntity = new ParqueaderoEntity(LocalDateTime.now(),TIPO_VEHICULO_MOTO, null, 0.0, ESTADO_INGRESO, PLACA);
		
		// act
		repositorioParqueo.guardarIngresoParqueo(parqueaderoGuardarEntity);
		
		ParqueaderoEntity parqueaderoEntity = repositorioParqueo.consultarParqueoPorPlaca(PLACA);
		parqueaderoEntity.setFechaSalida(LocalDateTime.now());
		parqueaderoEntity.setEstado("S");
		parqueaderoEntity.setMontoCobrado(5000.0);
		
		repositorioParqueo.guardarSalidaParqueo(parqueaderoEntity);
		double actual = repositorioParqueo.consultarParqueoPorPlaca(PLACA).getMontoCobrado();
		Assert.assertEquals(5000.0, actual,0);
	}
}
