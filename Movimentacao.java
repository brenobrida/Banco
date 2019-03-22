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

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public boolean isDs() {
		return ds;
	}

}