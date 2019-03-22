package ExInicial;

import java.util.Scanner;

public class Banco {
	public static Scanner read = new Scanner(System.in);
	protected int posAg = 0, posCli = 0;
	protected Agencia[] ag = new Agencia[100];
	protected Cliente[] lcli = new Cliente[100];

	public void adicionarAg(String nome, String endereco) {
		ag[posAg] = new Agencia(nome, endereco);
		posAg++;
	}
	
	public void adicionarCli(Cliente c) {
		lcli[posCli] = c;
		posCli++;
	}
	
	public Agencia[] getAg() {
		return ag;
	}
}