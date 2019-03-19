package ExInicial;
import java.util.Scanner;

public class ContaPoupanca extends Conta{
	public static Scanner read = new Scanner(System.in);
	private float variacao, vrendimento;
	
	public ContaPoupanca(Conta c, float variacao,float vrendimento) {
		super(c.numero, c.saldo, c.lespecial, c.lsaque, c.cespecial);
		this.variacao = variacao;
		this.vrendimento = vrendimento;
	}
	
	public static ContaPoupanca novaCP() {
		System.out.print("Digite a variação: ");
		float v = read.nextFloat();
		
		System.out.print("Digite o valor de rendimento mensal: ");
		float vr = read.nextFloat();
		
		return new ContaPoupanca(Conta.novaConta(), v, vr);
	}
}