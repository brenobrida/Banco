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
	
	public static ContaPoupanca novaCP() {
		System.out.print("Digite a variaÃ§Ã£o: ");
		int v = read.nextInt();
		
		System.out.print("Digite o valor de rendimento mensal: ");
		float vr = read.nextFloat();
		
		return new ContaPoupanca(Conta.novaConta(), v, vr);
	}
	
	public void adicionarMovimentacao() {
		boolean k = false, j = false;
		double sa;
		
		Movimentacao ob = Movimentacao.novaM();
		
		k = ob.isDs();
		sa = ob.getValor();
	
		if(k) {
			j = verificaLimite();
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
	
	public boolean verificaLimite() {
		boolean l = false;
		
		Movimentacao ob = Movimentacao.novaM();
		double sa = ob.getValor();
		
		Conta obc = Conta.novaConta();
		double ls = obc.getLsaque();
		
		if(sa <= ls) {
			l = true;
		}
		
		return l;		
	}
}