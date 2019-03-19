
public class PessoaFisica extends Cliente{

	public int cpf;
	public String estcivil;
	
	public PessoaFisica(String nome,String endereco, int telefone, String email, int cpf, String estcivil){
		super(nome, endereco, telefone, email);
		this.cpf = cpf;
		this.estcivil = estcivil;
	}
}
