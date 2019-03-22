package ExInicial;
import java.util.Scanner;

public class ContaPoupanca extends Conta{
	public static Scanner read = new Scanner(System.in);
	private int variacao;
	private float vrendimento;
	int mov = 0;
	
	public ContaPoupanca(Conta c, int variacao,float vrendimento) {
		super(c.saldo, c.lsaque, c.cli, c.ag);
		this.variacao = variacao;
		this.vrendimento = vrendimento;
		
	}
	
	public void adicionarMovimentacao(Movimentacao ob) {
		double sa;
		sa = ob.getValor();

		if (ob.isDs()) {
			if (verificaLimite(sa)) {
				m[this.getMov()] = ob;				
				this.setMov(this.getMov() + 1);
				
				saldo -= sa;
			} else
				System.out.println("ERRO! Seu limite nao eh suficiente para completar a transacao!\n");
		} else {
			m[this.getMov()] = ob;
			this.setMov(this.getMov() + 1);
			
			saldo += sa;
		}
	}
	
	public boolean verificaLimite(double sa) {
		boolean l = false;
		
		if(sa <= saldo && sa <= lsaque) {

			l = true;
		}
		
		return l;		
	}
}