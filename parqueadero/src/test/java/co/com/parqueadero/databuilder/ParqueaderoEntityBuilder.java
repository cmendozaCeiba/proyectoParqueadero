package co.com.parqueadero.databuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import co.com.parqueadero.persistencia.entidad.ParqueaderoEntity;

public class ParqueaderoEntityBuilder {

	private static final LocalDateTime FECHAINGRESO = LocalDateTime.now();
	private static final LocalDateTime FECHASALIDA =  LocalDateTime.of(2018, 04,22,10,30);
	private static final String TIPOVEHICULO = "Carro";
	private static final String ESTADO = "I";
	private static final String PLACA = "SRT05A";
	private static final double CILINDREAJE = 0.0;
	private static final double MONTOCOBRADO = 0.0;
	
	private BigDecimal id;
	private LocalDateTime fechaIngreso;
	private String tipoVehiculo;
	private LocalDateTime fechaSalida;
	private double montoCobrado;
	private String estado;
	private String placa;
	private double cilindraje;
	
	public ParqueaderoEntityBuilder() {
		this.fechaIngreso = FECHAINGRESO;
		this.tipoVehiculo = TIPOVEHICULO;
		this.fechaSalida = FECHASALIDA;
		this.montoCobrado = MONTOCOBRADO;
		this.estado =  ESTADO;
		this.placa = PLACA;
		this.cilindraje = CILINDREAJE;
	}
	
	
	
	public ParqueaderoEntity build() {
		return new ParqueaderoEntity(this.fechaIngreso,this.tipoVehiculo,this.fechaSalida,this.montoCobrado,this.estado,this.placa);
	}
	
	public ParqueaderoEntityBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public ParqueaderoEntityBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	
	public ParqueaderoEntityBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public ParqueaderoEntityBuilder conMontoCobrado(double montoCobrado) {
		this.montoCobrado = montoCobrado;
		return this;
	}
	
	public ParqueaderoEntityBuilder conEstado(String estado) {
		this.estado = estado;
		return this;
	}
	
	public ParqueaderoEntityBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public ParqueaderoEntityBuilder conCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
}
