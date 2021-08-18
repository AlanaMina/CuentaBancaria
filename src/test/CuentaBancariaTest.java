package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import cuentas.CuentaAhorro;
import cuentas.Cuenta;
import cuentas.CuentaCorriente;
import cuentas.Transaccion;

public class CuentaBancariaTest {

	@Test
	public void inicializacionCuenta() {
		Cuenta c1 = new Cuenta(100);
		assertNotNull(c1);
	}

	@Test
	public void comprobarSaldo() {
		Cuenta c1 = new Cuenta(100);
		assertEquals(100, c1.getSaldo(), 0.001);
	}
	
	@Test (expected = Error.class)
	public void comprobarRetiroErroneo() {
		Cuenta c1 = new Cuenta(100);
		c1.retirar(-100);
	}
	
	@Test (expected = Error.class)
	public void comprobarRetiroDemasiado() {
		Cuenta c1 = new Cuenta(100);
		c1.retirar(200);
	}
	
	@Test
	public void comprobarRetiro() {
		Cuenta c1 = new Cuenta(100);
		c1.retirar(20);
		assertEquals(80, c1.getSaldo(), 0.001);
	}
	
	@Test (expected = Error.class)
	public void comprobarDepositoErroneo() {
		Cuenta c1 = new Cuenta(100);
		c1.depositar(-100);
	}
	
	@Test
	public void comprobarDeposito() {
		Cuenta c1 = new Cuenta(100);
		c1.depositar(100);
		assertEquals(200, c1.getSaldo(), 0.001);
	}
	
	@Test (expected = Error.class)
	public void comprobarTransferenciaErronea() {
		Cuenta c1 = new Cuenta(100);
		Cuenta c2 = new Cuenta(100);
		c1.transferir(-100, c2);
	}
	
	@Test
	public void comprobarTransferencia() {
		Cuenta c1 = new Cuenta(100);
		Cuenta c2 = new Cuenta(100);
		c1.transferir(50, c2);
		assertEquals(50, c1.getSaldo(), 0.001);
	}
	
	@Test (expected = Error.class)
	public void comprobarRetiroDemasiadoAhorro() {
		CuentaAhorro c1 = new CuentaAhorro(100);
		c1.retirar(80);
	}
	
	@Test
	public void comprobarRetiroAhorro() {
		CuentaAhorro c1 = new CuentaAhorro(100);
		c1.retirar(60);
		assertEquals(40, c1.getSaldo(), 0.001);
	}
	
	@Test (expected = Error.class)
	public void comprobarRetiroDemasiadoCorriente() {
		CuentaCorriente c1 = new CuentaCorriente(100, 50);
		c1.retirar(200);
	}
	
	@Test
	public void comprobarRetiroCorriente() {
		CuentaCorriente c1 = new CuentaCorriente(100, 50);
		c1.retirar(130);
		assertEquals(-30, c1.getSaldo(), 0.001);
	}
	
	@Test
	public void transacciones() {		
		Cuenta cuentaOrigen = new Cuenta(1000);
		Cuenta cuentaDestino = new Cuenta(0);
		cuentaOrigen.transferir(550, cuentaDestino);
		String cuentaOrigenActual = Arrays.deepToString(cuentaOrigen.mostrarTransacciones());
		String cuentaDestinoActual = Arrays.deepToString(cuentaDestino.mostrarTransacciones());
		
		String cuentaOrigenexpected = "[Creación de cuenta por el valor de 1000, Retiro por el valor de 550, Transferencia por el valor de 550, null, null, null, null, null, null, null]";
		String cuentaDestinoexpected = "[Creación de cuenta por el valor de 0, Depósito por el valor de 550, null, null, null, null, null, null, null, null]";
		
		assertEquals(cuentaOrigenexpected, cuentaOrigenActual);
		assertEquals(cuentaDestinoexpected, cuentaDestinoActual);
	}
}