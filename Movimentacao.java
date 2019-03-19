package ExInicial;
import java.util.Scanner;

public class Movimentacao{
	public static Scanner read = new Scanner(System.in);
	private String descricao;
	private float valor;
	private boolean ds;
	
	public Movimentacao(String descricao, float valor, boolean ds) {
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
		
		return new Movimentacao(d, v, ds);
	}
}