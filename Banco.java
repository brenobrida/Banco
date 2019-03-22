package ExInicial;

import java.util.Scanner;

public class Banco {
	public static Scanner read = new Scanner(System.in);
	private String nome;
	private int i = 0;
	private Conta[] ac;

	public Banco(String nome, int q) {
		this.nome = nome;
		ac = new Conta[q];
	}

	public static Banco novoBanco() {
		System.out.print("Digite o nome do banco: ");
		String n = read.next();

		System.out.print("Digite a quantidade de contas: ");
		int q = read.nextInt();

		return new Banco(n, q);
	}

	private int consultarPos() {
		int k = -1;

		System.out.print("Numero da conta: ");
		int n = read.nextInt();

		for (int j = 0; j < i; j++) {
			if (ac[j].getNumero() == n)
				k = j;
		}

		return k;
	}

	public void criarConta() {
		int op;

		do {
			System.out.print("Menu:\n 1 - Conta Corrente\n 2 - Conta Poupanca\nOpcao: ");
			op = read.nextInt();
		} while (op < 1 || op > 2);

		switch (op) {
		case 1:
			ac[i] = ContaCorrente.novaCC(i);
			i++;
			break;
		case 2:
			ac[i] = ContaPoupanca.novaCP(i);
			i++;
			break;
		}
		System.out.println("Conta criada com sucesso!\n");
	}

	public void excluirConta() {
		listarContas();

		int pos = consultarPos();

		if (pos != -1) {
			for (int j = pos; j < i - 1; j++) {
				ac[j] = ac[j + 1];
			}
			
			i--;
			ac[i] = null;
			
			System.out.println("Conta excluida com sucesso!\n");
		} else
			System.out.println("Conta nao encontrada!\n");
	}

	public void listarContas() {
		System.out.println("Contas cadastradas: ");
		
		for (int j = 0; j < i; j++) {
			System.out.println("Numero da conta: " + ac[j].getNumero());
		}
		
		System.out.println(" ");
	}

	public void emitirSaldo() {
		listarContas();

		int pos = consultarPos();

		if (pos != -1) {
			System.out.println("Saldo: R$" + ac[pos].getSaldo() + "\n");
		} else
			System.out.println("Conta nao encontrada!\n");
	}

	public void emitirExtrato() {
		listarContas();

		int pos = consultarPos();

		if (pos != -1) {
			System.out.println("Saques:\n");
			for (Movimentacao m : ac[pos].getM()) {
				if (m.isDs())
					System.out.println(m.getDescricao() + " - " + m.getValor());
			}
      
			System.out.println("-------------------------");
			
      System.out.println("Depositos:\n");
			for (Movimentacao m : ac[pos].getM()) {
				if (!m.isDs())
					System.out.println(m.getDescricao() + " - " + m.getValor());
			}
			
      System.out.println("\n");
		} else
			System.out.println("Conta nao encontrada!\n");
	}

	public void transacao() {
		listarContas();

		int pos = consultarPos();

		if (pos != -1) {
			ac[pos].adicionarMovimentacao();
		} else
			System.out.println("Conta nao encontrada!\n");
	}

	public void transferencia() {

		System.out.println("Digite o valor da transferencia:");
		double valor = read.nextInt();

		listarContas();

		int pos1 = consultarPos();

		if (pos1 != -1) {
			int pos2 = consultarPos();
			boolean m = ac[pos1].verificaLimite(valor);
			
			if (pos2 != -1 && m == true) {
				ac[pos1].saldo -= valor;
				ac[pos2].saldo += valor;
				System.out.println("Transferencia concluida!");

			} else
				System.out.println("Conta nao encontrada!");

		} else
			System.out.println("Conta nao encontrada!");

		System.out.println("Tranferencia nao concluida!");

	}
}