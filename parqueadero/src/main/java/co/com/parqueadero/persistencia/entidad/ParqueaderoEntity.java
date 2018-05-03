package co.com.parqueadero.persistencia.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name ="parqueadero")
@NamedQueries({@NamedQuery(name="ParqueaderoEntity.buscarPorPlaca", query="SELECT p FROM parqueadero p WHERE p.placa = :placa"),
			@NamedQuery(name="ParqueaderoEntity.listarParqueo", query="SELECT p FROM parqueadero p")})
public class ParqueaderoEntity {
	
	@Id
	@GeneratedValue
	private BigDecimal id;
	
	@Column(name="fechaingreso",
			nullable=false)
	private LocalDateTime fechaIngreso;
	
	@Column(name="tipovehiculo",
			nullable=false)
	private String tipoVehiculo;
	
	@Column(name="fechasalida")
	private LocalDateTime fechaSalida;
	
	@Column(name="montocobrado")
	private double montoCobrado;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="placa")
	private String placa;
	
	@Column(name="cilindraje")
	private double cilindraje;
	
	public ParqueaderoEntity() {
	}

	public ParqueaderoEntity(LocalDateTime fechaIngreso, String tipoVehiculo, LocalDateTime fechaSalida, double montoCobrado, String estado, String placa) {
		this.fechaIngreso = fechaIngreso;
		this.tipoVehiculo = tipoVehiculo;
		this.fechaSalida = fechaSalida;
		this.montoCobrado = montoCobrado;
		this.estado = estado;
		this.placa = placa;
	}

	public BigDecimal getId() {
		return id;
	}
	
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public void setMontoCobrado(double montoCobrado) {
		this.montoCobrado = montoCobrado;
	}

	public double getMontoCobrado() {
		return montoCobrado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	public double getCilindraje() {
		return cilindraje;
	}
}
