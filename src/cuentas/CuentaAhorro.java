package cuentas;

public class CuentaAhorro extends Cuenta {
	private static double SALDO_SECUNDARIO = 0.7;
	
	public CuentaAhorro(int saldoInicial) {
		super(saldoInicial);
	}

	@Override
	public void retirar(double retiro) {
		super.validarMonto(retiro);
		if (saldo*SALDO_SECUNDARIO < retiro) {
			throw new Error("No puede extraer m�s dinero del que tiene");
		}
		this.saldo -= retiro;
		this.crearTransaccion(MotivoTransaccion.EXTRACION, retiro, this, this);
	}
}
