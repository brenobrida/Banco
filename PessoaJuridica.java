
public class PessoaJuridica  extends Cliente{

	int CNPJ;
	
	public PessoaJuridica(String nome,String endereco, int telefone, String email, int cnpj){
		super(nome, endereco, telefone, email);
		this.CNPJ = cnpj;
	}
}
