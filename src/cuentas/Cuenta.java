package cuentas;

import java.util.Arrays;

public class Cuenta {
	protected int saldo = 0;
	private Transaccion[] transacciones;
	private final static int CANT_TRANSACCIONES = 10;
	private int cant_transacciones = 0;
	
	public Cuenta(int saldoInicial) {
		this.validarMonto(saldoInicial);
		this.saldo = saldoInicial;
		this.transacciones = new Transaccion[CANT_TRANSACCIONES];
		this.crearTransaccion(MotivoTransaccion.DEPOSITO, saldoInicial, this, this);
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
		this.crearTransaccion(MotivoTransaccion.EXTRACION, d, this, this);
	}
	
	protected void validarMonto(double d) {
		if (d < 0) {
			throw new Error("El monto no puede ser negativo");
		}
	}
	
	public void depositar(int deposito) {
		this.validarMonto(deposito);
		this.saldo += deposito;
		this.crearTransaccion(MotivoTransaccion.DEPOSITO, deposito, this, this);
	}
	
	public void transferir(int monto, Cuenta cuentaDestino) {
		this.validarMonto(monto);
		this.retirar(monto);
		cuentaDestino.depositar(monto);
		//¿Qué pasaría la operación de transferir se ve interrumpida a la mitad de su ejecución? ¿Cómo se podría prevenir esto?
		this.crearTransaccion(MotivoTransaccion.TRANSFERENCIA, monto, this, cuentaDestino);
	}
	
	public void crearTransaccion(MotivoTransaccion motivo, double d, Cuenta origen, Cuenta destino) {
		Transaccion transaccion = new Transaccion(motivo, d, origen, destino);
		transacciones[cant_transacciones] = transaccion;
		cant_transacciones++;
	}
	
	public Transaccion[] mostrarTransacciones() {
		return transacciones;
	}
	
	public void ordenarPorFecha() {
		Arrays.sort(this.transacciones,0, this.cant_transacciones, new ComparadorFecha());
	}
	
	public void ordenarPorMotivo() {
		Arrays.sort(this.transacciones, 0, this.cant_transacciones);
	}
	
	public void ordenarPorMonto() {
		Arrays.sort(transacciones,0, this.cant_transacciones, new ComparadorPorMonto());
	}

	public void extraerDebito(double d) {
		this.validarMonto(d);
		if (saldo < d) {
			throw new Error("No puede usar más dinero del que tiene");
		}
		this.saldo -= d;
		this.crearTransaccion(MotivoTransaccion.COMPRA_DEBITO, d, this, this);
	}

	public void extraerCredito(double d) {
		this.validarMonto(d);
		if (saldo < d) {
			throw new Error("No puede usar más dinero del que tiene");
		}
		this.saldo -= d;
		this.crearTransaccion(MotivoTransaccion.COMPRA_CREDITO, d, this, this);
	}

	public void acreditarPlazoFijo(double d) {
		this.validarMonto(d);
		this.saldo += d;
		this.crearTransaccion(MotivoTransaccion.ACREDITAMIENTO_PLAZO_FIJO, d, this, this);
	}

	public void reservarPlazoFijo(double d) {
		this.validarMonto(d);
		if (saldo < d) {
			throw new Error("No puede usar más dinero del que tiene");
		}
		this.saldo -= d;
		this.crearTransaccion(MotivoTransaccion.RESERVAR_PLAZO_FIJO, d, this, this);
	}
}
