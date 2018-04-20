package co.com.parqueadero.dominio;

import java.util.ArrayList;
import java.util.List;

import co.com.parqueadero.constante.Constante;

public class Parqueadero {

	private static List<Vehiculo> ingresos = new ArrayList<>(Constante.CAPACIDAD_PARQUEADERO);
	private static Parqueadero parqueadero;

	
	public static Parqueadero getInstance() {
		if(parqueadero==null) {
			parqueadero = new Parqueadero();
		}
		return parqueadero;
	}
	
	public void agregarIngreso(Vehiculo vehiculo) {
		ingresos.add(vehiculo);
	}
	
	public void agregarSalida(Vehiculo vehiculo) {
		ingresos.remove(vehiculo);
	}
	
	public List<Vehiculo> getIngresos() {
		return ingresos;
	}
}
