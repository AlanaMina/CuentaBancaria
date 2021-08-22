package cuentas;

public class TarjetaCredito extends Producto implements Comprable{
	private double montoAcumulado;
	
	public TarjetaCredito(Cuenta cuenta) {
		super(cuenta);
	}
	
	@Override
	public void comprar(double monto) {
		this.montoAcumulado += monto;
	}
	
	public void pagar() {
		this.cuenta.extraerCredito(this.montoAcumulado * 1.03);
		this.montoAcumulado = 0;
	}
}
