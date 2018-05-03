package co.com.parqueadero.dominio.factoria;

import co.com.parqueadero.dominio.ParqueaderoApi;
import co.com.parqueadero.dominio.Vehiculo;

public interface VehiculoMetodoFactoria {

	public Vehiculo crearVehiculo(ParqueaderoApi parqueaderoApi);
	
}
