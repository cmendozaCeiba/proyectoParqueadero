package co.com.parqueadero.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.parqueadero.dominio.regla.ReglaVigilante;
import co.com.parqueadero.dominio.regla.ValidarPlaca;
import co.com.parqueadero.dominio.regla.VerificarDisponibilidad;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;
import co.com.parqueadero.persistencia.repositorio.RepositorioParqueaderoPersistente;

public class Vigilante {
	
	private List<ReglaVigilante> reglasIngreso = new ArrayList<>();
	private RepositorioParqueadero repositorioParqueo = new RepositorioParqueaderoPersistente();
	
	public Vigilante() {
		reglasIngreso.add(new VerificarDisponibilidad());
		reglasIngreso.add(new ValidarPlaca());
	}

	public void ingresarVehiculo(Vehiculo vehiculoIngresar) {
		reglasIngreso.stream().forEach(regla -> regla.ejecutarRegla(vehiculoIngresar));
		Parqueadero.getInstance().agregarIngreso(vehiculoIngresar);
		repositorioParqueo.guardarIngresoParqueo(convertirParqueaderoEntity(vehiculoIngresar));
	}

	private ParqueaderoEntity convertirParqueaderoEntity(Vehiculo vehiculo) {
		return new ParqueaderoEntity(new Date(), vehiculo.getClass().getSimpleName(), null, 0.0, "I", vehiculo.getPlaca());
	}
	
}
