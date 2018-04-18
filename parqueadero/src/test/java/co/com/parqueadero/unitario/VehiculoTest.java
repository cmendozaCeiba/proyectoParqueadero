package co.com.parqueadero.unitario;

import org.junit.Before;
import org.junit.Test;

import co.com.parqueadero.dominio.repositorio.RepositorioVehiculo;
import co.com.parqueadero.persistencia.repositorio.RepositorioVehiculoPersistente;

public class VehiculoTest {
	
	RepositorioVehiculo repositorioVehiculo;

	@Before
	public void iniciarPrueba() {
		repositorioVehiculo = new RepositorioVehiculoPersistente();
	}
	
	@Test
	public void guardarVehiculoTest() {
		//Arrange
			
		//Act
		
		//Assert
			
	}
	
}
