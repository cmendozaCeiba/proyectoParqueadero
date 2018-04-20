package co.com.parqueadero.dominio;

import java.util.ArrayList;
import java.util.List;

import co.com.parqueadero.dominio.regla.ReglaVigilante;
import co.com.parqueadero.dominio.regla.ValidarPlaca;
import co.com.parqueadero.dominio.regla.VerificarDisponibilidad;

public class Vigilante {
	
	private static Vigilante vigilante;
	
	private List<ReglaVigilante> reglasIngreso = new ArrayList<>();
	
	public Vigilante() {
		reglasIngreso.add(new VerificarDisponibilidad());
		reglasIngreso.add(new ValidarPlaca());
	}

	public static Vigilante getInstance() {
		if(vigilante==null) {
			vigilante = new Vigilante();
		}
		return vigilante;
	}

	public void ingresarVehiculo(Vehiculo vehiculoIngresar) {
		reglasIngreso.stream().forEach(regla -> regla.ejecutarRegla(vehiculoIngresar));
		Parqueadero.getInstance().agregarIngreso(vehiculoIngresar);
	}
	
}
