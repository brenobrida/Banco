package ExInicial;

import java.util.Scanner;

public class Conta {
	public static Scanner read = new Scanner(System.in);
	
	protected String numero;
	protected float saldo, lsaque;
	protected Movimentacao[] m;
	
	public Conta(String numero, float saldo, float lsaque) {
		this.numero = numero;
		this.saldo = saldo;
		this.lsaque = lsaque;
	}
	
	public static Conta novaConta() {
		System.out.print("Digite o numero da conta: ");
		String n = read.next();
		
		System.out.print("Digite o saldo: ");
		float s = read.nextFloat();
		
		System.out.print("Digite o limite de saque: ");
		float ls = read.nextFloat();
		
		Conta c = new Conta(n, s, ls);
		
		return c;
	}
	
	public void adicionarMovimentacao() {			
			
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getLsaque() {
		return lsaque;
	}

	public void setLsaque(float lsaque) {
		this.lsaque = lsaque;
	}

	public Movimentacao[] getM() {
		return m;
	}

	public void setM(Movimentacao[] m) {
		this.m = m;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
}
