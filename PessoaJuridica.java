package ExInicial;

public class PessoaJuridica  extends Cliente{

	int cnpj = 0;
	
	public PessoaJuridica(Cliente c, int cnpj){
		super(c.nome, c.endereco, c.email, c.telefone);
		this.cnpj = cnpj;
	}
}
