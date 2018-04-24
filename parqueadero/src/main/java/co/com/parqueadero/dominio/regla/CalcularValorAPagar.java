package co.com.parqueadero.dominio.regla;

import java.time.Duration;

import co.com.parqueadero.constante.Constante;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Vehiculo;
import static co.com.parqueadero.constante.Constante.ZERO;

public class CalcularValorAPagar implements ReglaVigilante{

	@Override
	public void ejecutarRegla(Vehiculo vehiculo) {
		
		double montoCobrar = ZERO;
		
		if(vehiculo instanceof Moto) {
			Moto moto = (Moto) vehiculo;
			montoCobrar = moto.getCilindraje() > Constante.CILINDRAJE ? Constante.COBRO_POR_CILINDRAJE : ZERO;
			montoCobrar =  montoCobrar + calcularValorPagar(vehiculo,Constante.VALOR_DIA_MOTO, Constante.VALOR_HORA_MOTO);
		}else {
			montoCobrar = calcularValorPagar(vehiculo,Constante.VALOR_DIA_CARRO, Constante.VALOR_HORA_CARRO);
		}
		
		vehiculo.setMontoCobrar(montoCobrar);
	}

	private double calcularValorPagar(Vehiculo vehiculo, double valorDiaVehiculo, double valorHoraVehiculo) {
		
		long duracionMinutos = Duration.between(vehiculo.getFechaIngreso(), vehiculo.getFechaSalida()).toMinutes();
		
		double horas = (duracionMinutos/Constante.CANTIDAD_MINUTOS_HORA);
		double dias = (horas/Constante.CANTIDAD_HORAS_DIA);
		int diaEntero = (int) dias;
		double restante = dias  - diaEntero;
		
		double horasRestante  =  restante*Constante.CANTIDAD_HORAS_DIA;
		
		double cantidadPago = ZERO;
		
		if(horas >= Constante.CANTIDAD_HORAS_DIA) {
			cantidadPago = diaEntero * valorDiaVehiculo;
			cantidadPago = cantidadPago + (horasRestante * valorHoraVehiculo);
			
		}else {
			cantidadPago = horas*valorHoraVehiculo;
		}
			
		
		return cantidadPago;
	}

}
