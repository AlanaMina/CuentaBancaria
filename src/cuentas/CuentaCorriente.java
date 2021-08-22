package cuentas;

public class CuentaCorriente extends Cuenta {
	private final double LIMITE_DESCUBIERTO;
	
	public CuentaCorriente(int saldoInicial, int extra) {
		super(saldoInicial);
		this.LIMITE_DESCUBIERTO = extra;
	}

	@Override
	public void retirar(double retiro) {
		super.validarMonto(retiro);
		if ((saldo+this.LIMITE_DESCUBIERTO) < retiro) {
			throw new Error("No puede extraer más dinero del que tiene");
		}
		this.saldo -= retiro;
		this.crearTransaccion(MotivoTransaccion.EXTRACION, retiro, this, this);
	}
}
