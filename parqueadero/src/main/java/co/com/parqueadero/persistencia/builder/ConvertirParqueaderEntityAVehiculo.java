package co.com.parqueadero.persistencia.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.parqueadero.dominio.Vehiculo;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@Component
public class ConvertirParqueaderEntityAVehiculo implements Converter<List<ParqueaderoEntity>, List<Vehiculo>>{

	@Override
	public List<Vehiculo> convert(List<ParqueaderoEntity> parqueaderosEntity) {
		List<Vehiculo> vehiculos =  new ArrayList<>();
		parqueaderosEntity.forEach(parqueo ->{
			Vehiculo vehiculo = new Vehiculo(parqueo.getPlaca(), parqueo.getMontoCobrado(), parqueo.getFechaIngreso(), parqueo.getFechaSalida());
			vehiculos.add(vehiculo);
		});
		return vehiculos;
	}

}
