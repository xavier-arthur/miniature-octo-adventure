import java.util.ArrayList;
import java.util.Calendar;

public class CadCompra implements Vetor, Ordenacao {

	private ArrayList<Compra> lista;

	// Instanciar a lista do tipo Compra
	public CadCompra() {
		lista = new ArrayList<>();
	}
	
	// Esse método pesquisa uma compra passando uma compra como parâmetro
	public Boolean pesquisa(Compra compra) {
		for (int i = 0; i < lista.size(); i++) {
			if (compra.getCliente().getNome().equalsIgnoreCase(lista.get(i).getCliente().getNome())) {
				return true;
			}
		}
		return false;
	}

	// Esse método retorna uma compra em determinada posição
	public Compra getPos(int posicao) {

		Compra compra = lista.get(posicao);
		if (compra != null) {
			return compra;
		}
		return null;
	}

	// Esse método retorna a posição de um cliente comparando o CPF dos mesmos
	public int getPosicao(String CPF) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCliente().getCpf() == CPF) {
				return i;
			}
		}
		return -1;
	}

	// Esse método retorna o tamanho da lista
	public int listaSize() {
		return lista.size();
	}

	// Esse método remove uma compra recebendo um CPF e uma data
	@Override
	public String remove(String cpf, Calendar data) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCliente().getCpf().equals(cpf) && lista.get(i).getData().equals(data)) {
				lista.remove(i);
				i--;
				return "Compra Removida!";
			}
		}
		return "Compra não encontrada!";
	}

	// imprime na tela todas as compras da lista
	public void toStringLista() {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) instanceof Compra) {
				Compra com = lista.get(i);
				System.out.println(com.toString());
			}

		}
	}
	// esse método insere uma compra na lista
	@Override
	public void insere(Compra compra) {
		lista.add(compra);
	}

	@Override
	public void insercaoDireta() {
		// TODO Auto-generated method stub
	}

	@Override
	public void quickSort() {
		// TODO Auto-generated method stub

	}

	@Override
	public void quickComInsercao() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shellSort() {
		// TODO Auto-generated method stub

	}

	@Override
	public Compra get(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

}
