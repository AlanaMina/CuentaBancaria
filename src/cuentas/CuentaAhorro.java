package cuentas;

public class CuentaAhorro extends Cuenta {
	private static double SALDO_SECUNDARIO = 0.7;
	
	public CuentaAhorro(int saldoInicial) {
		super(saldoInicial);
	}

	@Override
	public void retirar(int retiro) {
		super.validarMonto(retiro);
		if (saldo*SALDO_SECUNDARIO < retiro) {
			throw new Error("No puede extraer más dinero del que tiene");
		}
		this.saldo -= retiro;
		this.crearTransaccion("Retiro", retiro);
	}
}
