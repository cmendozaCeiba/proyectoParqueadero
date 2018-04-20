package co.com.parqueadero.unitario;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.parqueadero.constante.Constante;
import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.Vigilante;
import co.com.parqueadero.exception.ParqueaderoException;

public class VigilanteTest {

	private Vigilante vigilante;
	
	private static final String PLACA = "sdd215";
	private static final int CILINDRAJE = 800;
	
	@Before
	public void setUp() {
		vigilante = Vigilante.getInstance();
	}
	
	@Test
	public void ingresarVehiculoMotoMayorCapacidadTest() {
		try {
			
			for(int i=0;i<10;i++) {
				Vehiculo vehiculo = new Moto(PLACA, CILINDRAJE);
				
				vigilante.ingresarVehiculo(vehiculo);
			}
			
			fail();
			
		}catch(ParqueaderoException pe) {
			Assert.assertEquals(Constante.MENSAJE_PARQUEADERO_LLENO_MOTO, pe.getMessage());
		}
	}
	
	
	@Test
	public void ingresarVehiculoCarroMayorCapacidadTest() {
		try {
			
			for(int i=0;i<20;i++) {
				Vehiculo vehiculo = new Carro(PLACA);
				
				vigilante.ingresarVehiculo(vehiculo);
			}
			
			fail();
			
		}catch(ParqueaderoException pe) {
			Assert.assertEquals(Constante.MENSAJE_PARQUEADERO_LLENO_CARRO, pe.getMessage());
		}
	}
}
