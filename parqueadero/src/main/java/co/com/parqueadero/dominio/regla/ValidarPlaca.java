package co.com.parqueadero.dominio.regla;

import java.time.DayOfWeek;
import java.time.LocalDate;

import co.com.parqueadero.constante.Constante;
import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.exception.ParqueaderoException;

public class ValidarPlaca implements ReglaVigilante{

	private static final String A = "A";
	private static final int ZERO = 0;
		
	@Override
	public void ejecutarRegla(Vehiculo vehiculo) {
		
		if(vehiculo instanceof Carro && vehiculo.getPlaca().toUpperCase().codePointAt(ZERO) == A.codePointAt(ZERO)
				&& !esDomingoOLunes(LocalDate.now())) {
			
			throw new ParqueaderoException(Constante.MENSAJE_VEHICULO_NO_VALIDO);
		}
	}
		

	public boolean esDomingoOLunes(LocalDate fechaActual) {
		return fechaActual.getDayOfWeek().equals(DayOfWeek.SUNDAY) || fechaActual.getDayOfWeek().equals(DayOfWeek.MONDAY);
	}

}
