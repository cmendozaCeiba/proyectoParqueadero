package co.com.parqueadero.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.parqueadero.dominio.regla.CalcularValorAPagar;
import co.com.parqueadero.dominio.regla.ReglaVigilante;
import co.com.parqueadero.dominio.regla.ValidarPlaca;
import co.com.parqueadero.dominio.regla.VerificarDisponibilidad;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;
import co.com.parqueadero.persistencia.repositorio.RepositorioParqueaderoPersistente;

public class Vigilante {
	
	private List<ReglaVigilante> reglasIngreso = new ArrayList<>();
	private List<ReglaVigilante> reglasSalida = new ArrayList<>();
	private RepositorioParqueadero repositorioParqueo = new RepositorioParqueaderoPersistente();
	
	public Vigilante() {
		reglasIngreso.add(new VerificarDisponibilidad());
		reglasIngreso.add(new ValidarPlaca());
		reglasSalida.add(new CalcularValorAPagar());
	}

	public void ingresarVehiculo(Vehiculo vehiculoIngresar) {
		reglasIngreso.stream().forEach(regla -> regla.ejecutarRegla(vehiculoIngresar));
		Parqueadero.getInstance().agregarIngreso(vehiculoIngresar);
		repositorioParqueo.guardarIngresoParqueo(convertirParqueaderoEntity(vehiculoIngresar));
	}
	
	public void salidaVehiculo(Vehiculo vehiculoSalida) {
		reglasSalida.stream().forEach(reglaSalida -> reglaSalida.ejecutarRegla(vehiculoSalida));
		Parqueadero.getInstance().agregarSalida(vehiculoSalida);
		// Temrinar la paete del guardado de salida
		repositorioParqueo.guardarSalidaParqueo(null);
	}

	private ParqueaderoEntity convertirParqueaderoEntity(Vehiculo vehiculo) {
		return new ParqueaderoEntity(new Date(), vehiculo.getClass().getSimpleName(), null, 0.0, "I", vehiculo.getPlaca());
	}
	
}
