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
		System.out.print("Digite a variação: ");
		int v = read.nextInt();
		
		System.out.print("Digite o valor de rendimento mensal: ");
		float vr = read.nextFloat();
		
		return new ContaPoupanca(Conta.novaConta(), v, vr);
	}
}