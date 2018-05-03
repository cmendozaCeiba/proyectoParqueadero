package co.com.parqueadero.persistencia.convertidor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.parqueadero.dominio.ParqueaderoApi;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@Component
public class ListaParqueaderoEntityAListaParqueaderoApi implements Converter<List<ParqueaderoEntity>, List<ParqueaderoApi>>{

	@Override
	public List<ParqueaderoApi> convert(List<ParqueaderoEntity> parqueaderosEntity) {
		List<ParqueaderoApi> parqueaderoApis =  new ArrayList<>();
		parqueaderosEntity.forEach(parqueo ->{
			ParqueaderoApi parqueaderoApi = new ParqueaderoApi();
			parqueaderoApi.setId(parqueo.getId());
			parqueaderoApi.setFechaIngreso(parqueo.getFechaIngreso());
			parqueaderoApi.setTipoVehiculo(parqueo.getTipoVehiculo());
			parqueaderoApi.setFechaSalida(parqueo.getFechaSalida());
			parqueaderoApi.setMontoCobrado(parqueo.getMontoCobrado());
			parqueaderoApi.setEstado(parqueo.getEstado());
			parqueaderoApi.setPlaca(parqueo.getPlaca());
			parqueaderoApi.setCilindraje(parqueo.getCilindraje());
			parqueaderoApis.add(parqueaderoApi);
		});
		return parqueaderoApis;
	}

}
