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
}
