package ExInicial;
import java.util.Scanner;

public class Movimentacao extends Conta{
	public static Scanner read = new Scanner(System.in);
	private String descricao;
	private float valor;
	private boolean ds;
	
	public Movimentacao(Conta c, String descricao, float valor, boolean ds) {
		super(c.numero, c.saldo, c.lespecial, c.lsaque, c.cespecial);
		this.descricao = descricao;
		this.valor = valor;
		this.ds = ds;
	}
	
	public Movimentacao novaM() {
		System.out.print("Digite a descrição: ");
		String d = read.next();
		
		System.out.print("Digite o valor: ");
		float v = read.nextFloat();
		
		System.out.print("Saque ou depósito? (S/D): ");
		boolean ds = read.next().toUpperCase().charAt(0) == 'S';
		
		return new Movimentacao(this.Conta, d, v, ds);
	}
}