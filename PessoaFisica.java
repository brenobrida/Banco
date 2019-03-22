package ExInicial;

public class PessoaFisica extends Cliente {

	String cpf, ecivil;
	
	public PessoaFisica(Cliente c, String cpf, String estcivil){
		super(c.nome, c.endereco, c.email, c.telefone);
		this.cpf = cpf;
		this.ecivil = estcivil;
	}
}
