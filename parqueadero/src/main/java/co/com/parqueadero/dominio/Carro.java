package co.com.parqueadero.dominio;

import java.time.LocalDateTime;

public class Carro extends Vehiculo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5962447071101443503L;

	public Carro(String placa, double montoCobrado, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		super(placa,montoCobrado, fechaIngreso, fechaSalida);
	}
	
}
