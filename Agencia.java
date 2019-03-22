package ExInicial;

import java.util.Scanner;

public class Agencia{
	public static Scanner read = new Scanner(System.in);
	
	static int contador = 0;
	int numero, posC = 0, posAC = 0;
	String nome, endereco;
	protected Conta[] ac = new Conta[100];
	protected Cliente[] c = new Cliente[100];
	
	public Agencia(String nome, String endereco){
		this.numero = contador++;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public void adicionarPessoaF (String nome, String endereco, String email, int telefone, String cpf, String estcivil) {
		c[posC] = new PessoaFisica(new Cliente(nome, endereco, email, telefone), cpf, estcivil);
		posC++;
	}
	
	public void adicionarPessoaJ (String nome, String endereco, String email, int telefone, int cnpj) {
		c[posC] = new PessoaJuridica(new Cliente(nome, endereco, email, telefone), cnpj);
		posC++;
	}
	
	public void criarContaC(float saldo, float lsaque, Cliente cli,  boolean cespecial, double lespecial) {
		ac[posAC] = new ContaCorrente(new Conta(saldo, lsaque, cli, this), cespecial, lespecial);
		posAC++;
	}
	
	public void criarContaP(float saldo, float lsaque, Cliente cli, int variacao, float vrendimento) {
		ac[posAC] = new ContaPoupanca(new Conta(saldo, lsaque, cli, this), variacao, vrendimento);
		posAC++;
	}
	
	public void excluirConta(int pos) {
		for (int j = pos; j < posAC - 1; j++) {
			ac[j] = ac[j + 1];
		}
			
		posAC--;
		ac[posAC] = null;
	}

	public void emitirSaldo(int pos) {
		System.out.println("Saldo: R$" + ac[pos].getSaldo() + "\n");
	}

	public void emitirExtrato(int pos) {
		ac[pos].extrato();
	}

	public void transacao(int pos, String descricao, double valor, boolean ds) {
		ac[pos].adicionarMovimentacao(new Movimentacao(descricao, valor, ds));
	}

	public void transferencia(int pos1, int pos2, double valor) {
		ac[pos1].adicionarMovimentacao(new Movimentacao("Transferencia entre contas", valor, true));
		ac[pos2].adicionarMovimentacao(new Movimentacao("Transferencia entre contas", valor, false));
		System.out.println("Transferencia concluida!\n");
	}

	public Cliente[] getC() {
		return c;
	}
	
	public Conta[] getAc() {
		return ac;
	}
}
