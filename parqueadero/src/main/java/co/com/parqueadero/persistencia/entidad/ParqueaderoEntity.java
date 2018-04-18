package co.com.parqueadero.persistencia.entidad;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name ="parqueadero")
public class ParqueaderoEntity {
	
	@Id
	@GeneratedValue
	private BigDecimal id;
	
	@Column(name="fechaingreso",
			nullable=false)
	private Date fechaIngreso;
	
	@Column(name="tipovehiculo",
			nullable=false)
	private String tipoVehiculo;
	
	@Column(name="fechasalida")
	private Date fechaSalida;
	
	@Column(name="montocobrado")
	private double montoCobrado;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="placa")
	private String placa;

	public ParqueaderoEntity(Date fechaIngreso, String tipoVehiculo, Date fechaSalida, double montoCobrado, String estado, String placa) {
		this.fechaIngreso = fechaIngreso;
		this.tipoVehiculo = tipoVehiculo;
		this.fechaSalida = fechaSalida;
		this.montoCobrado = montoCobrado;
		this.estado = estado;
		this.placa = placa;
	}



}