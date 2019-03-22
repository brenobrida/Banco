package ExInicial;
import java.util.*;

public class Main {
	private static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco banco = Banco.novoBanco();	//Instanciando um novo banco
		
		//Criacao de contas
		banco.criarConta();		//Criar conta 1
		//banco.criarConta();		//Criar conta 2
		//banco.criarConta();		//Criar conta 3
		//banco.listarContas();	//Listar contas cadastradas
		
		//Exclusao de uma conta
		//banco.excluirConta();	//Excluir uma conta
		//banco.emitirSaldo();	//Emissao de saldo
		
		//Saque
		banco.transacao();		//Transacao 1
		
		//Deposito
		//banco.transacao();		//Transacao 2
		
		//Transferencia entre contas
		//banco.transferencia();	//Transferencia
		//banco.emitirSaldo();	//Emissao de saldo
		//banco.emitirSaldo();	//Emissao de saldo
	}

}
