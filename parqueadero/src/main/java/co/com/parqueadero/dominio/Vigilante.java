package co.com.parqueadero.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.com.parqueadero.dominio.regla.CalcularValorAPagar;
import co.com.parqueadero.dominio.regla.ReglaVigilante;
import co.com.parqueadero.dominio.regla.ValidarPlaca;
import co.com.parqueadero.dominio.regla.VerificarDisponibilidad;
import co.com.parqueadero.dominio.repositorio.RepositorioParqueadero;
import co.com.parqueadero.persistencia.builder.VehiculoBuilder;
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
		vehiculoIngresar.setFechaIngreso(LocalDateTime.now());
		repositorioParqueo.guardarIngresoParqueo(VehiculoBuilder.convertirParqueaderoEntity(vehiculoIngresar, "I"));
		
	}
	
	public void salidaVehiculo(Vehiculo vehiculoSalida) {
		
		reglasSalida.stream().forEach(reglaSalida -> reglaSalida.ejecutarRegla(vehiculoSalida));
		Parqueadero.getInstance().agregarSalida(vehiculoSalida);
		
		ParqueaderoEntity parqueoSalida = repositorioParqueo.consultarParqueoPorPlaca(vehiculoSalida.getPlaca());
		
		parqueoSalida.setMontoCobrado(vehiculoSalida.getMontoCobrar());
		parqueoSalida.setFechaSalida(vehiculoSalida.getFechaSalida());
		parqueoSalida.setEstado("S");
		
		repositorioParqueo.guardarSalidaParqueo(parqueoSalida);
	}
	
}
