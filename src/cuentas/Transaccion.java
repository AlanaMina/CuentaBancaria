package cuentas;

import java.util.Date;
import java.util.Objects;

public class Transaccion implements Comparable<Transaccion>{
	private MotivoTransaccion motivo;
	private double monto;
	private Date fecha;
	private Cuenta origen;
	private Cuenta destino;
	
	public Transaccion(MotivoTransaccion motivo, double d, Cuenta origen, Cuenta destino) {
		this.monto = d;
		this.motivo = motivo;
		this.fecha = new Date();
		this.origen = origen;
		this.destino = destino;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
	@Override
	public String toString() {
		return this.motivo + " por el valor de " + this.monto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, monto, motivo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		return Objects.equals(fecha, other.fecha) && monto == other.monto && Objects.equals(motivo, other.motivo);
	}

	@Override
	public int compareTo(Transaccion o) {
		return this.motivo.compareTo(o.motivo);
	}
	
	public Double getMonto() {
		return this.monto;
	}
}
