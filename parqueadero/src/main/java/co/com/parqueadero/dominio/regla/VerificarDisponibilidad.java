package co.com.parqueadero.dominio.regla;

import java.util.List;

import co.com.parqueadero.constante.Constante;
import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Parqueadero;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.exception.ParqueaderoException;

public class VerificarDisponibilidad implements ReglaVigilante{

	List<Vehiculo> ingresos = Parqueadero.getInstance().getIngresos();
	
	@Override
	public void ejecutarRegla(Vehiculo vehiculo) {
		if(vehiculo instanceof Moto && 
				ingresos.stream().filter(vh -> vh instanceof Moto).count() >= Constante.CAPACIDAD_PARQUEADERO_MOTO) {
			throw new ParqueaderoException(Constante.MENSAJE_PARQUEADERO_LLENO_MOTO);
		}
			
		if(vehiculo instanceof Carro &&
				ingresos.stream().filter(vh -> vh instanceof Carro).count() >= Constante.CAPACIDAD_PARQUEADERO_CARRO) {
			throw new ParqueaderoException(Constante.MENSAJE_PARQUEADERO_LLENO_CARRO);
		}
		
	}
}
