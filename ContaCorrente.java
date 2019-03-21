package ExInicial;

public class ContaCorrente extends Conta{
	private boolean cespecial;
	private double lespecial;
	
	public ContaCorrente(Conta c, boolean cespecial, double lespecial) {
		super(c.numero, c.saldo, c.lsaque);
		this.cespecial = cespecial;
		this.lespecial = lespecial;
	}
	
	public static ContaCorrente novaCC() {
		float le = 0;
		
		System.out.print("A conta possui cheque especial? (S/N): ");
		boolean ce = read.next().toUpperCase().charAt(0) == 'S';
		
		if(ce) {
			System.out.print("Digite o limite de cheque especial: ");
			le = read.nextFloat();
		}
		
		return new ContaCorrente(Conta.novaConta(), ce, le);
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
