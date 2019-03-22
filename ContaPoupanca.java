package ExInicial;
import java.util.Scanner;

public class ContaPoupanca extends Conta{
	public static Scanner read = new Scanner(System.in);
	private int variacao;
	private float vrendimento;
	
	public ContaPoupanca(Conta c, int variacao,float vrendimento) {
		super(c.numero, c.saldo, c.lsaque);
		this.variacao = variacao;
		this.vrendimento = vrendimento;
	}

	public static ContaPoupanca novaCP(int i) {
		System.out.print("Digite a variacao: ");

		int v = read.nextInt();
		
		System.out.print("Digite o valor de rendimento mensal: ");
		float vr = read.nextFloat();
		
		return new ContaPoupanca(Conta.novaConta(i), v, vr);
	}
	
	public void adicionarMovimentacao() {
		double sa;

		Movimentacao ob = Movimentacao.novaM();
		sa = ob.getValor();

		if (ob.isDs()) {
			if (verificaLimite(sa)) {
				saldo -= sa;
			
				System.out.println("Seu saldo da conta corrente eh de: R$" + saldo);
				System.out.println("Saque efetuado com sucesso!\n");
			} else
				System.out.println("ERRO! Seu limite nao eh suficiente para completar a transacao!\n");
			
		} else {
			saldo += sa;
			System.out.println("Seu novo saldo eh de: " + saldo);
			System.out.println("Deposito efetuado com sucesso!\n");
		}
	}
	
	public boolean verificaLimite(double sa) {
		boolean l = false;
		
		if(sa <= saldo && sa <= lsaque) {

			l = true;
		}
		
		return l;		
	}
	
	public void adicionarMovimentacao() {
		boolean k = false, j = false;
		double sa;
		
		Movimentacao ob = Movimentacao.novaM();
		
		k = ob.isDs();
		sa = ob.getValor();
	
		if(k) {

			j = verificaLimite(sa);

			if(j && (saldo - sa) > 0) {
				saldo -=  sa;
				System.out.println("Saque efetuado com sucesso!");
				System.out.println("Seu novo saldo é de: "+saldo);
			}else {
				System.out.println("Saldo insuficiente!");
			}
		}else {
			saldo +=  sa;
			System.out.println("Depósito efetuado com sucesso!");
			System.out.println("Seu novo saldo é de: "+saldo);
		}
	}
	
	public boolean verificaLimite(double sa) {
		boolean l = false;
		
		if(sa <= saldo) {

			l = true;
		}
		
		return l;		
	}
}