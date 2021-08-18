package cuentas;

import java.util.Date;
import java.util.Objects;

public class Transaccion {
	private String motivo;
	private int monto;
	private Date fecha;
	
	public Transaccion(String motivo, int monto, Date date) {
		this.monto = monto;
		this.motivo = motivo;
		this.fecha = date;
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
}
