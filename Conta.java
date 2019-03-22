package ExInicial;

import java.util.Scanner;

public class Conta {
	public static Scanner read = new Scanner(System.in);
	
	protected int numero;
	static int contador = 0;
	protected float saldo, lsaque;
	protected Movimentacao[] m = new Movimentacao[1000];
	protected int mov = 0;
	protected Cliente cli;
	protected Agencia ag;

	public Conta(float saldo, float lsaque, Cliente cli, Agencia ag) {
		this.numero = contador++;
		this.saldo = saldo;
		this.lsaque = lsaque;
		this.cli = cli;
		this.ag = ag;
	}
	
	public int getMov() {
		return mov;
	}
	
	public void setMov(int mov) {
		this.mov = mov;
	}
	
	public void extrato() {
		System.out.println("Saques:\n");
		
		for (int i = 0; i < mov; i++) {
			if (m[i].isDs())
				System.out.println(m[i].getDescricao() + " - " + m[i].getValor());
		}
  
		System.out.println("-------------------------");
		
		System.out.println("Depositos:\n");
  		for (int i = 0; i < mov; i++) {
  			if (!m[i].isDs())
				System.out.println(m[i].getDescricao() + " - " + m[i].getValor());
		}
		
  		System.out.println("\n");
	}
	
	public void adicionarMovimentacao(String descricao, double valor, boolean ds) {			
			
	}
	
	public void adicionarMovimentacao(Movimentacao m) {			
		
	}
	
	public boolean verificaLimite(double sa) {
		return true;
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

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getSaldo() {
		return saldo;
	}
	
	public Movimentacao[] getM() {
		return m;
	}
}
