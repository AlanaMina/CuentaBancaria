package cuentas;

public class TarjetaDebito extends Producto implements Comprable{
	
	public TarjetaDebito(Cuenta cuenta) {
		super(cuenta);
	}

	@Override
	public void comprar(double monto) {
		this.cuenta.extraerDebito(monto);
	}
}
