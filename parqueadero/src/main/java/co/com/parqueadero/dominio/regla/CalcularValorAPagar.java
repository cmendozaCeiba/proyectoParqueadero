package co.com.parqueadero.dominio.regla;

import java.time.Duration;
import java.time.LocalDateTime;

import co.com.parqueadero.constante.Constante;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Vehiculo;

public class CalcularValorAPagar implements ReglaVigilante{

	@Override
	public void ejecutarRegla(Vehiculo vehiculo) {
		if(vehiculo instanceof Moto) {
			Moto moto = (Moto) vehiculo;
			double montoCobrar = moto.getCilindraje() > 500 ? 2000 : 0;
			montoCobrar =  montoCobrar + calcularValorPagar(vehiculo.getFechaIngreso());
			System.out.println(montoCobrar);
		}
	}

	private double calcularValorPagar(LocalDateTime fechaIngreso) {
		
		long duracionMinutos = Duration.between(fechaIngreso, LocalDateTime.now()).toMinutes();
		
		double horas = (duracionMinutos/Constante.CANTIDAD_MINUTOS_HORA);
		int dias = (int) horas;
		double restante = horas  - dias;
		
		int horasRestante  = (int) restante*Constante.CANTIDAD_HORAS_DIA;
		
		double cantidadPago = 0;
		
		if(horas >= Constante.CANTIDAD_HORAS_DIA) {
			cantidadPago = dias * Constante.VALOR_DIA_MOTO;
			cantidadPago = cantidadPago + (horasRestante * Constante.VALOR_HORA_MOTO);
			
		}else {
			cantidadPago = horas*Constante.VALOR_HORA_MOTO;
		}
			
		
		return cantidadPago;
	}

}
