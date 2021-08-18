package cuentas;

import java.util.Comparator;

public class ComparadorFecha implements Comparator<Transaccion>{

	@Override
	public int compare(Transaccion t1, Transaccion t2) {
		return t1.getFecha().compareTo(t2.getFecha());
	}

}
