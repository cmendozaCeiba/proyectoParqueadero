package co.com.parqueadero.dominio.factoria;

import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Vehiculo;

public class VehiculoFactoria implements VehiculoMetodoFactoria{

	@Override
	public Vehiculo crearVehiculo(String cilindraje) {
		if(cilindraje>0)
			return new Moto(vehiculo.getPlaca(),vehiculo.getMontoCobrar(),vehiculo.getCilindraje(),vehiculo.getFechaIngreso(),vehiculo.getFechaSalida());
	}

}
