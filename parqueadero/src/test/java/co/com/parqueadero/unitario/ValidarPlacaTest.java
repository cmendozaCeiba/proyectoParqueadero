package co.com.parqueadero.unitario;

import org.junit.Test;

import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.regla.ValidarPlaca;

public class ValidarPlacaTest {

	@Test
	public void validarPlaca() {
		ValidarPlaca validarPlaca = new ValidarPlaca();
		validarPlaca.ejecutarRegla(new Carro("rt"));
	}
}
