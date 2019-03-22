package ExInicial;
import java.util.*;

public class Main {
	private static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = new Banco();	//Instanciando um novo banco
		
		banco.adicionarAg("Trindade", "Floripa");
		
		banco.getAg()[0].adicionarPessoaF("Brendon", "Joao Nadir", "bredstone13@gmail.com", 991353538, "47658292869", ":'(");
		banco.getAg()[0].adicionarPessoaJ("Breno", "Cezarium", "brenodebrida@gmail.com", 991792464, 979870001);
		banco.adicionarCli(banco.getAg()[0].getC()[0]);
		banco.adicionarCli(banco.getAg()[0].getC()[1]);
		
		banco.getAg()[0].criarContaC(100, 100, banco.getAg()[0].getC()[0], true, 100);
		banco.getAg()[0].criarContaP(150, 50, banco.getAg()[0].getC()[1], 10, 100);
		
		banco.getAg()[0].emitirSaldo(0);
		banco.getAg()[0].emitirSaldo(1);
		
		banco.getAg()[0].transacao(0, "Saque", 50, true);
		banco.getAg()[0].emitirSaldo(0);
		
		banco.getAg()[0].transacao(0, "Deposito", 70, false);
		banco.getAg()[0].emitirSaldo(0);
		
		banco.getAg()[0].transferencia(1, 0, 20);
		banco.getAg()[0].emitirSaldo(0);
		banco.getAg()[0].emitirSaldo(1);
		
		banco.getAg()[0].getAc()[0].extrato();
	}

}
