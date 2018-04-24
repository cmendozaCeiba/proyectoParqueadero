package co.com.parqueadero.unitario;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.dominio.regla.CalcularValorAPagar;
import co.com.parqueadero.dominio.regla.ReglaVigilante;

public class CalcularValorAPagarTest {

	ReglaVigilante calcularvalorPagar = new CalcularValorAPagar();
	
	@Test
	public void calcularValorPagarMotoTest() {
		Vehiculo vehiculo = new Moto("we", 0.0, 650, LocalDateTime.of(2018, 4, 22, 13, 00), LocalDateTime.of(2018, 4, 22, 23, 00));
		calcularvalorPagar.ejecutarRegla(vehiculo);
		
		Assert.assertEquals(vehiculo.getMontoCobrar(), 6500, 0);
	}
	
	@Test
	public void calcularValorPagarMotoHoraTest() {
		Vehiculo vehiculo = new Moto("we", 0.0, 650, LocalDateTime.of(2018, 4, 22, 13, 00), LocalDateTime.of(2018, 4, 22, 14, 25));
		calcularvalorPagar.ejecutarRegla(vehiculo);
		
		Assert.assertEquals(vehiculo.getMontoCobrar(), 2500, 0);
	}
	
	@Test
	public void calcularValorPagarCarroTest() {
		Vehiculo vehiculo = new Carro("we", 0.0, LocalDateTime.of(2018, 4, 22, 06, 00), LocalDateTime.of(2018, 4, 22, 18, 00));
		calcularvalorPagar.ejecutarRegla(vehiculo);
		
		Assert.assertEquals(vehiculo.getMontoCobrar(), 11000, 0);
		
	}
	
	@Test
	public void calcularValorPagarCarroHoraTest() {
		Vehiculo vehiculo = new Carro("we", 0.0, LocalDateTime.of(2018, 4, 22, 6, 00), LocalDateTime.of(2018, 4, 22, 8, 00));
		calcularvalorPagar.ejecutarRegla(vehiculo);
		
		Assert.assertEquals(vehiculo.getMontoCobrar(), 2000, 0);
		
	}
}
