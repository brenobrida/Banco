package ExInicial;


public class ContaCorrente extends Conta {
	private boolean cespecial;
	private double lespecial;
	int mov = 0;

	public ContaCorrente(Conta c, boolean cespecial, double lespecial) {
		super(c.saldo, c.lsaque, c.cli, c.ag);
		this.cespecial = cespecial;
		this.lespecial = lespecial;

	}
	
	public void adicionarMovimentacao(Movimentacao ob) {
		double sa;
		sa = ob.getValor();

		if (ob.isDs()) {
			if (verificaLimite(sa)) {
				m[this.getMov()] = ob;				
				this.setMov(this.getMov() + 1);
				
				if (saldo <= sa) {
					lespecial += saldo - sa;
					saldo = 0;
				} else
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

		if (sa <= lsaque && sa <= saldo + lespecial) {
			l = true;
		}

		return l;
	}
}
