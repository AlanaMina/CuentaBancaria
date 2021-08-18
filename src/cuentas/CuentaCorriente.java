package cuentas;

public class CuentaCorriente extends Cuenta {
	private int extra;
	
	public CuentaCorriente(int saldoInicial, int extra) {
		super(saldoInicial);
		this.extra = extra;
	}

	@Override
	public void retirar(int retiro) {
		super.validarMonto(retiro);
		if ((saldo+this.extra) < retiro) {
			throw new Error("No puede extraer m�s dinero del que tiene");
		}
		this.saldo -= retiro;
		this.crearTransaccion("Retiro", retiro);
	}
}
