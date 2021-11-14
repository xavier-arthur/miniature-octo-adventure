import java.util.ArrayList;
import java.util.Calendar;

public class CadCompra implements Vetor, Ordenacao {

	private ArrayList<Compra> lista = new ArrayList<>();

	// Instanciar a lista do tipo Compra
	public CadCompra() {
		super();
	}

//LISTA VAZIA

	public boolean eVazio() {
		if (this.lista.size() == 0) {
			return true;
		}
		return false;
	}

	// Esse m�todo pesquisa uma compra passando uma compra como par�metro
	public Boolean pesquisa(Compra compra) {
		for (int i = 0; i < lista.size(); i++) {
			if (compra.getCliente().getNome().equalsIgnoreCase(lista.get(i).getCliente().getNome())) {
				return true;
			}
		}
		return false;
	}

	// Esse m�todo retorna uma compra em determinada posi��o
	public Compra getPos(int posicao) {

		Compra compra = lista.get(posicao);
		if (compra != null) {
			return compra;
		}
		return null;
	}

	public int getPosicao(String cpf) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCliente().getCpf().equals(cpf)) {
				return i;
			}
		}
		return -1;
	}

	public int listaSize() {
		return lista.size();
	}

	// Esse m�todo remove uma compra recebendo um CPF e uma data
	@Override
	public String remove(String cpf, Calendar data) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCliente().getCpf().equals(cpf) && lista.get(i).getData().equals(data)) {
				lista.remove(i);
				i--;
				return "Compra Removida!";
			}
		}
		return "Compra no encontrada!";
	}

	@Override
	public String toString() {
		var builder = new StringBuilder();

		for (int i = 0; i < lista.size(); i++) {

			if (lista.get(i).getCliente() instanceof ClienteEspecial) {
				ClienteEspecial cliEsp = (ClienteEspecial) lista.get(i).getCliente();
				builder.append(
                    String.join(";", new String[] {
                        cliEsp.getNome(),
                        cliEsp.getCpf(),
                        Double.toString(cliEsp.getValeCompra()),
                        ManipulaData.formatar(this.lista.get(i).getData()),
                        Double.toString(this.lista.get(i).getValor()) 
                    })
				);
			} else {
				Cliente cli = lista.get(i).getCliente();
				builder.append(
                    String.join(";", new String[] {
                        cli.getNome(),
                        cli.getCpf(),
                        ManipulaData.formatar(this.lista.get(i).getData()),
                        Double.toString(this.lista.get(i).getValor())
                    })
                );
			}
            builder.append("\n");
		}

        return builder.toString();
	}

	@Override
	public void insere(Compra compra) {
		lista.add(compra);
	}

	@Override
	public void insercaoDireta() {
		/*
			for (int i = 1; i < vetor.length; i++){
			
				int aux = vetor[i];
				int j = i;
				
				while ((j > 0) && (vetor[j-1] > aux)){
					vetor[j] = vetor[j-1];
					j -= 1;
				}
				vetor[j] = aux;
			}
		*/

		int i, j;
		long temp, atual;

		for (i = 1; i < this.lista.size() - 1; i++) {
			j = i;
			temp  = Long.parseLong(this.get(i).getCliente().getCpf());
			atual = Long.parseLong(this.lista.get(j - 1).getCliente().getCpf());

			while ((j > 0) && (atual > temp)) {
				this.lista.set(j + 1, this.lista.get(j--));
			}
			this.lista.set(j, this.lista.get(i));
		}
	}

	@Override
	public void quickSort() {
		ordena(0, this.listaSize() - 1);
	}

	private void ordena(int esq, int dir) {
		Long pivo;
		int i = esq, j = dir;
		Compra temp;

		pivo = Long.parseLong(this.lista.get((i + j) / 2).getCliente().getCpf());
		do {
			while (Long.parseLong(this.lista.get(i).getCliente().getCpf()) < pivo)
				i++;
			while (Long.parseLong(this.lista.get(j).getCliente().getCpf()) > pivo)
				j--;

			if (i <= j) {
				temp = this.lista.get(i);
				this.lista.set(i, this.lista.get(j));
				this.lista.set(j, temp);
				i++;
				j--;

			}

		} while (i <= j);
		if (esq < j)
			ordena(esq, j);
		if (dir > i)
			ordena(i, dir);

	}

	@Override
    public void shellSort() {
        int n = this.lista.size();
 
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1) {
                var temp = Long.parseLong(this.lista.get(i).getCliente().getCpf());
				var tmpObj = this.lista.get(i);
 
                int j;
                for (j = i; (j >= gap) && (Long.parseLong(this.lista.get(j - gap).getCliente().getCpf()) > temp); j -= gap) {
					this.lista.set(j, this.lista.get(j - gap));
				}
 
                this.lista.set(j, tmpObj);
            }
        }
    }

	@Override
	public void quickComInsercao() {
		// TODO Auto-generated method stub

	}

	@Override
	public Compra get(int pos) {
		return this.lista.get(pos);
	}
}
