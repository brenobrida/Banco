import java.util.ArrayList;

public class Banco {
	private static int next_id = 0;
	private ArrayList<Conta> list = new ArrayList();


	public ArrayList<Conta> getList() {
		return list;
	}

	public void setList(ArrayList<Conta> list) {
		this.list = list;
	}

	public String listar_clientes() {
		String str = new String();
		int i = 0;
		for(; i < list.size(); i++) {
			str += (i+1) + ". " + list.get(i).getNumero() + "\n";
		}

		str += (i+1) + ". Nenhum\n";
		return str;
	}

	void salvar_conta(Conta conta) {
		list.add(conta);
	}
	
	void criar_conta(int tipo) {
		Conta conta = new Conta();
		if(tipo == 1) {
			conta = new ContaCorrente();
		} else if(tipo == 2) {
			conta = new ContaPoupanca();
		}

		conta.setNumero(get_id_format(next_id));
		next_id++;
		this.salvar_conta(conta);

		System.out.print("A conta de numero (" + conta.getNumero() + ") foi criada.\n");
	}
	
	String get_id_format(int id) {

		int n = (""+id).length();

		String str = new String();
		for(int i = n; i < 6; i++) {
			str += "0";
		}
		str += id;

		return str;
	}

	void deletar_conta(String id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNumero().equals(id)) {
				int j;
				for(j = i+1; j < list.size(); j++) {
					list.add(j-1, list.get(j));
				}
				if(j < list.size()) {
					list.remove(j);
				} else {
					list.remove(i);
				}
				break;
			}
		}
		System.out.print("ssssss " + list.size() + " ssss\n");
	}
	
	Conta selecionar_conta(String id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNumero().equals(id)) {
				return list.get(i);
			}
		}

		return null;
	}
	
	void montar_movimentacao(String tipo, Conta c1, Conta c2, double valor) {

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setTipo(tipo);

		movimentacao.setTipo(tipo);
		movimentacao.setConta_um(c1);
		movimentacao.setConta_dois(c2);
		movimentacao.setValor(valor);
		movimentacao.executar_movimentacao();
		c1.getMovimentacao_list().add(movimentacao);
		if(c2 != null) c2.getMovimentacao_list().add(movimentacao);
	}
	
	
}
