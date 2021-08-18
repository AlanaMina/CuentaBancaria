package cuentas;

public class TarjetaCredito {
	private int saldo = 0;
	
	public void comprar(int monto) {
		this.saldo += monto;
	}
	
	public int saldoAcumulado() {
		return saldo;
	}
	
	public void debito(Cuenta cuenta) {
		cuenta.retirar(this.saldo * 1.03);
	}
}
