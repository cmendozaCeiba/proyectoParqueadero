package co.com.parqueadero.unitario;

import java.time.LocalDateTime;

import org.junit.Test;

import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.regla.CalcularValorAPagar;
import co.com.parqueadero.dominio.regla.ReglaVigilante;

public class CalcularValorAPagarTest {

	ReglaVigilante calcularvalorPagar = new CalcularValorAPagar();
	
	@Test
	public void calcularValorPagarTest() {
		calcularvalorPagar.ejecutarRegla(new Moto("we", 0.0, 800, LocalDateTime.of(2018, 4, 22, 11, 10), LocalDateTime.of(2018, 4, 23, 10, 20)));
		
	}
}
