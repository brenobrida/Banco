package ExInicial;

import java.util.Scanner;

public class Cliente {
	public static Scanner read = new Scanner(System.in);
	String nome = null,	endereco = null, email = null;
	int telefone; 
		
	public Cliente(String nome, String endereco, String email, int telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	
}
