package co.com.parqueadero.unitario;

import org.junit.Assert;
import org.junit.Test;

import co.com.parqueadero.constante.Constante;
import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.regla.ValidarPlaca;
import co.com.parqueadero.exception.ParqueaderoException;

public class ValidarPlacaTest {

	private static final String PLACA_INICIAL_A = "Art";
	
	@Test
	public void validarPlaca() {
		try {
			
			ValidarPlaca validarPlaca = new ValidarPlaca();
			validarPlaca.ejecutarRegla(new Carro(PLACA_INICIAL_A,0.0,null,null));
			
		}catch(ParqueaderoException pe) {
			Assert.assertEquals(Constante.MENSAJE_VEHICULO_NO_VALIDO, pe.getMessage());
		}
	}
}
