package ExInicial;

public class PessoaFisica extends Cliente{

	int cpf = 0;
	String estcivil = null;
	
	public PessoaFisica(String nome,String endereco, int telefone, String email, int cpf, String estcivil){
		super(nome, endereco, email, telefone);
		this.cpf = cpf;
		this.estcivil = estcivil;
	}
}
