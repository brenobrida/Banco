package ExInicial;
import java.util.Scanner;

public class Movimentacao{
	public static Scanner read = new Scanner(System.in);
	private String descricao;
	private double valor;
	private boolean ds;
	
	public Movimentacao(String descricao, double valor, boolean ds) {
		this.descricao = descricao;
		this.valor = valor;
		this.ds = ds;
	}
	
	
	public static Movimentacao novaM() {
		System.out.print("Digite a descricao: ");
		String d = read.next();
		
		System.out.print("Digite o valor: ");
		float v = read.nextFloat();
		
		System.out.print("Saque ou deposito? (S/D): ");
		boolean ds = read.next().toUpperCase().charAt(0) == 'S';
			
		return new Movimentacao(d, v, ds);
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public boolean isDs() {
		return ds;
	}


	public void setDs(boolean ds) {
		this.ds = ds;
	}
}