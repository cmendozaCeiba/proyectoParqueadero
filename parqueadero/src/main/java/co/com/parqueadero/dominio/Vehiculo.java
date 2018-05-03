package co.com.parqueadero.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "vehiculo")
public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 25254764857630978L;
	
	@JsonProperty
	private String placa;
	@JsonProperty 
	private double montoCobrar;
	@JsonProperty 
	private LocalDateTime fechaIngreso;
	@JsonProperty 
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setMontoCobrar(double montoCobrar) {
		this.montoCobrar = montoCobrar;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getMontoCobrar() {
		return montoCobrar;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
