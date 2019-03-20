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
		System.out.print("Digite o número da conta: ");
		String n = read.next();
		
		System.out.print("Digite o saldo: ");
		float s = read.nextFloat();
		
		System.out.print("Digite o limite de saque: ");
		float ls = read.nextFloat();
		
		Conta c = new Conta(n, s, ls);
		
		return c;
	}

	public Movimentacao[] getM() {
		return m;
	}

	public float getSaldo() {
		return saldo;
	}

	public String getNumero() {
		return numero;
	}
}
