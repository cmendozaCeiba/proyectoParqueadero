package co.com.parqueadero.unitario;

import org.junit.Assert;
import org.junit.Test;

import co.com.parqueadero.persistencia.conexion.ConexionDB;

public class ConexionDBTest {

	@Test
	public void veificarEntityManager(){
		ConexionDB conexion  = new ConexionDB();
		
		Assert.assertNotNull(conexion.getEntityManager());
	}
	
}
