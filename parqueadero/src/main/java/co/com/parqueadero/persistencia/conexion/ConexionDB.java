package co.com.parqueadero.persistencia.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionDB {

	private static final String UNIDAD_DE_PERSISTENCIA = "parqueadero-persistence";
	private EntityManager entityManager;
	
	public ConexionDB() {
		obtenerEntityManager();
	}
	
	private void obtenerEntityManager(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEntityManager(){
		return entityManager;
	}
	
	public void iniciarTransacion(){
		entityManager.getTransaction().begin();
	}
	
	public void finalizarTransacion() {
		entityManager.getTransaction().commit();
	}
	
	public void deshacerCambios(){
		entityManager.getTransaction().rollback();
	}
}
