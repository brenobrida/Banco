package ExInicial;

public class ContaCorrente extends Conta {
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

		if (ce) {
			System.out.print("Digite o limite de cheque especial: ");
			le = read.nextFloat();
		}

		return new ContaCorrente(Conta.novaConta(), ce, le);
	}

	public void adicionarMovimentacao() {
		boolean k = false, j = false;
		double sa;

		Movimentacao ob = Movimentacao.novaM();
		sa = ob.getValor();

		if (ob.isDs()) {
			if (verificaLimite(sa)) {
				if (saldo <= sa) {
					lespecial += saldo - sa;
					saldo = 0;
				} else
					saldo -= sa;
				
				System.out.println("Saque efetuado com sucesso!");
				System.out.println("Seu novo saldo é de: " + saldo);
			} else {
				System.out.println("Saldo insuficiente!");
			}
		} else {
			saldo += sa;
			System.out.println("Depósito efetuado com sucesso!");
			System.out.println("Seu novo saldo é de: " + saldo);
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
