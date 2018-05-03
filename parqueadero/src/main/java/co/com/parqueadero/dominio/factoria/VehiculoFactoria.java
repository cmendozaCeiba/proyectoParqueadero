package co.com.parqueadero.dominio.factoria;

import org.springframework.stereotype.Service;

import co.com.parqueadero.dominio.Carro;
import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.ParqueaderoApi;
import co.com.parqueadero.dominio.Vehiculo;

@Service
public class VehiculoFactoria implements VehiculoMetodoFactoria{

	@Override
	public Vehiculo crearVehiculo(ParqueaderoApi parqueaderoApi) {
		if(parqueaderoApi.getCilindraje()>0)
			return new Moto(parqueaderoApi.getPlaca(),parqueaderoApi.getMontoCobrado(),parqueaderoApi.getCilindraje(),parqueaderoApi.getFechaIngreso(),parqueaderoApi.getFechaSalida());
		else
			return new Carro(parqueaderoApi.getPlaca(), parqueaderoApi.getMontoCobrado(), parqueaderoApi.getFechaIngreso(), parqueaderoApi.getFechaSalida());
	}

}
