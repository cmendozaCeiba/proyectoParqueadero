package co.com.parqueadero.unitario;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.regla.ValidarPlaca;
import co.com.parqueadero.exception.ParqueaderoException;

public class ValidarPlacaTest {

	private static final String PLACA_INICIAL_A = "Art";
	
	@Test(expected=ParqueaderoException.class)
	public void validarPlaca() {
			ValidarPlaca validarPlaca = new ValidarPlaca();
			
			validarPlaca.ejecutarRegla(new Carro(PLACA_INICIAL_A,0.0,null,null));
	}
	
	@Test
	public void esDominogOLunesTest() {
		ValidarPlaca validarPlaca = new ValidarPlaca();
		LocalDate domingo = LocalDate.of(2018, 05, 06);
		
		boolean resultado = validarPlaca.esDomingoOLunes(domingo);
		
		Assert.assertTrue("mensaje",resultado);
	}
}
