package co.com.parqueadero.dominio;

import java.io.Serializable;

public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 25254764857630978L;
	
	protected String placa;
	protected double cilindraje;
	
	public Vehiculo(String placa, double cilindraje) {
		this.placa = placa;
		this.cilindraje = cilindraje;
	}

	
}
