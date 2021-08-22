package cuentas;

public class PlazoFijo extends Producto{
	private double reservado;
	private int meses;
	
	public PlazoFijo(Cuenta cuenta, double monto, int meses) {
		super(cuenta);
		this.reservado = monto;
		this.meses = meses;
		cuenta.reservarPlazoFijo(this.reservado);
	}
	
	public void acreditar() {
		for (int i = 0; i < meses; i++) {
			reservado *= (1 + (0.36/12)); 
		}
		this.cuenta.acreditarPlazoFijo(reservado);
	}
}
