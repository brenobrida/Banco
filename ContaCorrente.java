package ExInicial;


public class ContaCorrente extends Conta {
	private boolean cespecial;
	private double lespecial;

	public ContaCorrente(Conta c, boolean cespecial, double lespecial) {
		super(c.numero, c.saldo, c.lsaque);
		this.cespecial = cespecial;
		this.lespecial = lespecial;

	}

	public static ContaCorrente novaCC(int i) {
		float le = 0;

		System.out.print("A conta possui cheque especial? (S/N): ");
		boolean ce = read.next().toUpperCase().charAt(0) == 'S';

		if (ce) {
			System.out.print("Digite o limite de cheque especial: ");
			le = read.nextFloat();
		}

		return new ContaCorrente(Conta.novaConta(i), ce, le);
	}

	public void adicionarMovimentacao() {
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
			
				System.out.println("Seu saldo da conta corrente eh de: R$" + saldo);
				System.out.println("Seu saldo de cheque especial eh de: R$" + lespecial);
				System.out.println("Saque efetuado com sucesso!\n");
			} else {
				System.out.println("ERRO! Seu limite nao eh suficiente para completar a transacao!\n");
			}
		} else {
			saldo += sa;
			System.out.println("Seu novo saldo eh de: " + saldo);
			System.out.println("Deposito efetuado com sucesso!\n");
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
