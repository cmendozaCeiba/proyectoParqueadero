package co.com.parqueadero.persistencia.repositorio;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.conexion.ConexionDB;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

@Service
public class RepositorioParqueaderoPersistente implements RepositorioParqueadero{

	private static final String BUSCAR_PARQUEO_POR_PLACA = "ParqueaderoEntity.buscarPorPlaca";
	private static final String LISTAR_PARQUEO = "ParqueaderoEntity.listarParqueo";
	private static final String PLACA = "placa";
	ConexionDB conexionDB = new ConexionDB();
	
	@Override
	public void guardarIngresoParqueo(ParqueaderoEntity parqueaderoEntity) {
		conexionDB.iniciarTransacion();
		conexionDB.getEntityManager().persist(parqueaderoEntity);
		conexionDB.finalizarTransacion();
	}

	@Override
	public void guardarSalidaParqueo(ParqueaderoEntity parqueaderoEntity) {
		conexionDB.getEntityManager().merge(parqueaderoEntity);
		conexionDB.finalizarTransacion();
	}

	@Override
	public boolean existeParqueo(ParqueaderoEntity parqueaderoEntity) {
		
		Query query = conexionDB.getEntityManager().createNamedQuery(BUSCAR_PARQUEO_POR_PLACA, ParqueaderoEntity.class);
		query.setParameter(PLACA, parqueaderoEntity.getPlaca());
		return query.getSingleResult() != null;
	}

	@Override
	public ParqueaderoEntity consultarParqueoPorPlaca(String placa) {
		Query query = conexionDB.getEntityManager().createNamedQuery(BUSCAR_PARQUEO_POR_PLACA, ParqueaderoEntity.class);
		query.setParameter(PLACA, placa);
		return (ParqueaderoEntity) query.getSingleResult();
	}

	@Override
	public synchronized List<ParqueaderoEntity> listarParqueos() {
		Query query = conexionDB.getEntityManager().createNamedQuery(LISTAR_PARQUEO);
		return query.getResultList();
	}

}
