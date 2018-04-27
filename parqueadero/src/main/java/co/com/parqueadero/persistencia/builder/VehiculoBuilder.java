package co.com.parqueadero.persistencia.builder;

import co.com.parqueadero.dominio.Moto;
import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

public class VehiculoBuilder {
	
	public static ParqueaderoEntity convertirParqueaderoEntity(Vehiculo vehiculo, String estado) {
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity(vehiculo.getFechaIngreso(), vehiculo.getClass().getSimpleName(), vehiculo.getFechaSalida(), vehiculo.getMontoCobrar(),
				estado, vehiculo.getPlaca());
		
		if(vehiculo instanceof Moto) {
			Moto moto = (Moto) vehiculo;
			parqueaderoEntity.setCilindraje(moto.getCilindraje());
		}
		
		return parqueaderoEntity;
	}

	public static Vehiculo convertirVehiculo(ParqueaderoEntity parqueaderoEntity) {
		return new Vehiculo(parqueaderoEntity.getPlaca(), parqueaderoEntity.getMontoCobrado(), parqueaderoEntity.getFechaIngreso(), parqueaderoEntity.getFechaSalida());
	}
}
