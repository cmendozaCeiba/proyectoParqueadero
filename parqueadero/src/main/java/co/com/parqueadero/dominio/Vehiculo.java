package co.com.parqueadero.dominio;

import java.io.Serializable;

public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 25254764857630978L;
	
	protected String placa;
	
	public Vehiculo(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	
}
