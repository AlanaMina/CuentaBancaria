package cuentas;

public class PlazoFijo {
	Cuenta cuenta;
	private double monto;
	private int meses;
	
	public PlazoFijo(Cuenta cuenta, double monto, int meses) {
		this.monto = monto;
		this.cuenta = cuenta;
		this.meses = meses;
	}
	
	public void debitar() {
		for (int i = 0; i < meses; i++) {
			monto *= 1.36; 
		}
		cuenta.retirar(monto);
	}
}
