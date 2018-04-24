package co.com.parqueadero.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 25254764857630978L;
	
	protected String placa;
	private double montoCobrar;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	
	public Vehiculo(String placa, double montoCobrar, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		this.placa = placa;
		this.montoCobrar = montoCobrar;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public String getPlaca() {
		return placa;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setMontoCobrar(double montoCobrar) {
		this.montoCobrar = montoCobrar;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public double getMontoCobrar() {
		return montoCobrar;
	}
	
}
