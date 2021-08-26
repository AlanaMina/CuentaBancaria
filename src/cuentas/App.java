package cuentas;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		
		Cuenta miCuenta = new Cuenta(0);
		System.out.println(miCuenta.getSaldo()); // 0
		System.out.println(Arrays.deepToString(miCuenta.mostrarTransacciones()));

		miCuenta.depositar(1000);
		System.out.println(miCuenta.getSaldo()); // 1000
		System.out.println(Arrays.deepToString(miCuenta.mostrarTransacciones()));

		miCuenta.retirar(450);;
		System.out.println(miCuenta.getSaldo()); // 550
		System.out.println(Arrays.deepToString(miCuenta.mostrarTransacciones()));
		
		Cuenta cuentaOrigen = new Cuenta(1000);
		Cuenta cuentaDestino = new Cuenta(0);
		cuentaOrigen.transferir(550, cuentaDestino);
		System.out.println(cuentaOrigen.getSaldo()); //450
		System.out.println(cuentaDestino.getSaldo()); //550
		System.out.println(Arrays.deepToString(cuentaOrigen.mostrarTransacciones()));
		System.out.println(Arrays.deepToString(cuentaDestino.mostrarTransacciones()));
		cuentaOrigen.ordenarPorMotivo();
		System.out.println(Arrays.deepToString(cuentaOrigen.mostrarTransacciones()));
		cuentaOrigen.ordenarPorMonto();
		System.out.println(Arrays.deepToString(cuentaOrigen.mostrarTransacciones()));
		cuentaDestino.ordenarPorMotivo();
		System.out.println(Arrays.deepToString(cuentaDestino.mostrarTransacciones()));
		cuentaDestino.ordenarPorMonto();
		System.out.println(Arrays.deepToString(cuentaDestino.mostrarTransacciones()));
	}
}
