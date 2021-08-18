package cuentas;

public class TarjetaDebito {
	Cuenta cuenta;
	
	public TarjetaDebito(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public void comprar(double monto) {
		cuenta.retirar(monto);
	}
}
