package cuentas;

import java.util.Arrays;
import java.util.Date;

public class Cuenta {
	protected int saldo = 0;
	private Transaccion[] transacciones;
	private final static int CANT_TRANSACCIONES = 10;
	private int cant_transacciones = 0;
	
	public Cuenta(int saldoInicial) {
		this.validarMonto(saldoInicial);
		this.saldo = saldoInicial;
		this.transacciones = new Transaccion[CANT_TRANSACCIONES];
		this.crearTransaccion("Creación de cuenta", saldoInicial);
	}
	
	public int getSaldo() {
		return this.saldo;
	}
	
	public void retirar(double d) {
		this.validarMonto(d);
		if (saldo < d) {
			throw new Error("No puede extraer más dinero del que tiene");
		}
		this.saldo -= d;
		this.crearTransaccion("Retiro", d);
	}
	
	protected void validarMonto(double d) {
		if (d < 0) {
			throw new Error("El monto no puede ser negativo");
		}
	}
	
	public void depositar(int deposito) {
		this.validarMonto(deposito);
		this.saldo += deposito;
		this.crearTransaccion("Depósito", deposito);
	}
	
	public void transferir(int monto, Cuenta cuentaDestino) {
		this.validarMonto(monto);
		this.retirar(monto);
		cuentaDestino.depositar(monto);
		//¿Qué pasaría la operación de transferir se ve interrumpida a la mitad de su ejecución? ¿Cómo se podría prevenir esto?
		this.crearTransaccion("Transferencia", monto);
	}
	
	public void crearTransaccion(String motivo, double d) {
		Date date = new Date();
		Transaccion transaccion = new Transaccion(motivo, d, date);
		transacciones[cant_transacciones] = transaccion;
		cant_transacciones++;
	}
	
	public Transaccion[] mostrarTransacciones() {
		return transacciones;
	}
	
	public void ordenarPorFecha() {
		Arrays.sort(transacciones,0, this.cant_transacciones, new ComparadorFecha());
	}
}
