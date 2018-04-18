package co.com.parqueadero.persistencia.repositorio;

import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

public class RepositorioParqueaderoPersistente implements RepositorioParqueadero{

	@Override
	public void guardarIngresoParqueo(ParqueaderoEntity parqueaderoEntity) {
		
	}

	@Override
	public void guardarSalidaParqueo(ParqueaderoEntity parqueaderoEntity) {
		
	}

	@Override
	public boolean existeParqueo(ParqueaderoEntity parqueaderoEntity) {
		return false;
	}

}
