package ExInicial;

import java.util.Scanner;

public class Conta {
	public static Scanner read = new Scanner(System.in);
	protected String numero;
	protected float saldo, lespecial, lsaque;
	protected boolean cespecial;
	protected Movimentacao[] m;
	
	public Conta(String numero, float saldo, float lespecial, float lsaque, boolean cespecial) {
		this.numero = numero;
		this.saldo = saldo;
		this.lespecial = lespecial;
		this.lsaque = lsaque;
		this.cespecial = cespecial;
	}
	
	public static Conta novaConta() {
		float le = 0;
		
		System.out.print("Digite o número da conta: ");
		String n = read.next();
		
		System.out.print("Digite o saldo: ");
		float s = read.nextFloat();
		
		System.out.print("A conta possui cheque especial? (S/N): ");
		boolean ce = read.next().toUpperCase().charAt(0) == 'S';
		
		if(ce) {
			System.out.print("Digite o limite de cheque especial: ");
			le = read.nextFloat();
		}
		
		System.out.print("Digite o limite de saque: ");
		float ls = read.nextFloat();
		
		Conta c = new Conta(n, s, le, ls, ce);
		
		return c;
	}

	public String getNumero() {
		return numero;
	}
}
