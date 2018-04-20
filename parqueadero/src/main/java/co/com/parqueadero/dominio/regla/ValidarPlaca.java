package co.com.parqueadero.dominio.regla;

import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.exception.ParqueaderoException;

public class ValidarPlaca implements ReglaVigilante{

	private static final String A = "A";
	private static final int ZERO = 0;
		
	@Override
	public void ejecutarRegla(Vehiculo vehiculo) {
		
		if(vehiculo.getPlaca().toUpperCase().codePointAt(ZERO) == A.codePointAt(ZERO)
				&& vehiculo instanceof Carro) {
			System.out.println("Placa inicia con A");
		}else {
			throw new ParqueaderoException("Carro no valido para ingreso");
		}
	}

}
