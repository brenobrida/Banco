package ExInicial;

public class ContaCorrente extends Conta{
	
	public ContaCorrente(Conta c) {
		super(c.numero, c.saldo, c.lespecial, c.lsaque, c.cespecial);
	}
	
	public static ContaCorrente novaCC() {
		return new ContaCorrente(Conta.novaConta());
	}
}
