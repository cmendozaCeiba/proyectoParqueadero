package co.com.parqueadero.dominio.factoria;

import org.springframework.stereotype.Service;

import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Vehiculo;

@Service
public class VehiculoFactoria implements VehiculoMetodoFactoria{

	@Override
	public Vehiculo crearVehiculo(String cilindraje, Vehiculo vehiculo) {
		if(cilindraje!=null && !cilindraje.isEmpty())
			return new Moto(vehiculo.getPlaca(),vehiculo.getMontoCobrar(),Double.parseDouble(cilindraje),vehiculo.getFechaIngreso(),vehiculo.getFechaSalida());
		else
			return new Carro(vehiculo.getPlaca(), vehiculo.getMontoCobrar(), vehiculo.getFechaIngreso(), vehiculo.getFechaSalida());
	}

}
