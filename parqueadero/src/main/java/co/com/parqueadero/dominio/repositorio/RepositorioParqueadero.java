package co.com.parqueadero.dominio.repositorio;

import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

public interface RepositorioParqueadero {

	public void guardarIngresoParqueo(ParqueaderoEntity parqueaderoEntity);
	
	public void guardarSalidaParqueo(ParqueaderoEntity parqueaderoEntity);
	
	public boolean existeParqueo(ParqueaderoEntity parqueaderoEntity);
	
	public ParqueaderoEntity consultarParqueoPorPlaca(String placa);
	
}
