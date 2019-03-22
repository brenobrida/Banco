package ExInicial;

import java.util.Scanner;

public class Conta {
	public static Scanner read = new Scanner(System.in);
	
	protected int numero;
	protected float saldo, lsaque;
	protected Movimentacao[] m;
	
	public Conta(int numero, float saldo, float lsaque) {
		this.numero = numero;
		this.saldo = saldo;
		this.lsaque = lsaque;
	}
	
	public static Conta novaConta(int i) {
		System.out.print("Digite o saldo: ");
		float s = read.nextFloat();
		
		System.out.print("Digite o limite de saque: ");
		float ls = read.nextFloat();
		
		Conta c = new Conta(i, s, ls);
		
		return c;
	}
	
	public void adicionarMovimentacao() {			
			
	}
	public boolean verificaLimite(double sa) {
		return true;
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

	public int getNumero() {
		return numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public Movimentacao[] getM() {
		return m;
	}
}