package co.com.parqueadero.dominio;

import java.time.LocalDateTime;

public class Moto extends Vehiculo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8322905263810883341L;

	private double cilindraje;
	
	public Moto(String placa, double montoCobrado, double cilindraje, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		super(placa,montoCobrado, fechaIngreso, fechaSalida);
		
		this.cilindraje = cilindraje;
	}
	
	public double getCilindraje() {
		return cilindraje;
	}
}
