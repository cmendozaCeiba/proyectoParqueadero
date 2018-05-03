package co.com.parqueadero.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "parqueaderoApi")
public class ParqueaderoApi {

	@JsonProperty
	private BigDecimal id;
	
	@JsonProperty
	private LocalDateTime fechaIngreso;
	
	@JsonProperty
	private String tipoVehiculo;
	
	@JsonProperty
	private LocalDateTime fechaSalida;
	
	@JsonProperty
	private double montoCobrado;
	
	@JsonProperty
	private String estado;
	
	@JsonProperty
	private String placa;
	
	@JsonProperty
	private double cilindraje;
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public double getMontoCobrado() {
		return montoCobrado;
	}
	
	public void setMontoCobrado(double montoCobrado) {
		this.montoCobrado = montoCobrado;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public double getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}
}
