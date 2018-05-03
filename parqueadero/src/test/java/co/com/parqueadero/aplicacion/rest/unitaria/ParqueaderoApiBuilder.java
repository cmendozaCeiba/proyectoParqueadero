package co.com.parqueadero.aplicacion.rest.unitaria;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParqueaderoApiBuilder {
	private BigDecimal id;
	private LocalDateTime fechaIngreso;
	private String tipoVehiculo;
	private LocalDateTime fechaSalida;
	private double montoCobrado;
	private String estado;
	private String placa;
	private double cilindraje;
	
	public ParqueaderoApiBuilder() {
		fechaIngreso =   LocalDateTime.of(2018,04,28,10,30);
		tipoVehiculo = "Carro";
	}
	
}
