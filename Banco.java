package ExInicial;

import java.util.Scanner;

public class Banco {
	public static Scanner read = new Scanner(System.in);
	private String nome;
	private int i = 0;
	private Conta[] ac;
	
	public Banco (String nome, int q) {
		this.nome = nome;
		ac = new Conta[q];
	}
	
	public Banco novoBanco() {
		System.out.print("Digite o nome do banco: ");
		String n = read.next();
		
		System.out.print("Digite a quantidade de contas: ");
		int q = read.nextInt();
		
		return new Banco(n, q);
	}
	
	private int consultarPos() {
		int k = -1;
		
		System.out.print("Número da conta: ");
		String n = read.next();
		
		for(int j = 0; j <= i; j++) {
			if(ac[j].getNumero() == n)
				k = j;
		}
		
		return k;
	}
	
	public void criarConta() {
		int op;
		
		do {
			System.out.println("Menu:\n\n 1 - Conta Corrente\n 2 - Conta Poupança\nOpção: ");
			op = read.nextInt();
		} while(op < 1 || op > 2);
		
		switch(op) {
		case 1:
			ac[i] = ContaCorrente.novaCC();
			i++;
			break;
		case 2:
			ac[i] = ContaPoupanca.novaCP();
			i++;
			break;
		}
	}
	
	public void excluirConta() {
		int pos = consultarPos();
		
		if(pos != -1) {
			for(int j = pos; j <= i; j++) {
				
			}
		}
			
	}
	
	public boolean transacao() {
		
	}
	
	public float emitirSaldo() {
		
	}
	
	public Movimentacao[] emitirExtrato() {
		
	}
	
	public boolean transferir() {
		
	}
}
