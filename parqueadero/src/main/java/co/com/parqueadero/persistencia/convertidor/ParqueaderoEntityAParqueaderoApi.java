package co.com.parqueadero.persistencia.convertidor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.parqueadero.dominio.ParqueaderoApi;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@Component
public class ParqueaderoEntityAParqueaderoApi implements Converter<ParqueaderoEntity, ParqueaderoApi>{

	@Override
	public ParqueaderoApi convert(ParqueaderoEntity parqueaderoEntity) {
		ParqueaderoApi parqueaderoApi= new ParqueaderoApi();
		parqueaderoApi.setId(parqueaderoEntity.getId());
		parqueaderoApi.setFechaIngreso(parqueaderoEntity.getFechaIngreso());
		parqueaderoApi.setTipoVehiculo(parqueaderoEntity.getTipoVehiculo());
		parqueaderoApi.setFechaSalida(parqueaderoEntity.getFechaSalida());
		parqueaderoApi.setMontoCobrado(parqueaderoEntity.getMontoCobrado());
		parqueaderoApi.setEstado(parqueaderoEntity.getEstado());
		parqueaderoApi.setPlaca(parqueaderoEntity.getPlaca());
		parqueaderoApi.setCilindraje(parqueaderoEntity.getCilindraje());
		return parqueaderoApi;
	}

}
