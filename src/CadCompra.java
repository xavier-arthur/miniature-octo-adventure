import java.util.ArrayList;
import java.util.Calendar;

public class CadCompra implements Vetor, Ordenacao {

	private ArrayList<Compra> vetCompra;

	public CadCompra() {
	vetCompra = new ArrayList<Compra>();
	}

	// NIVALDO VARGAS CRUZ;53676030096;104.4;28/01/1992;4806.88
	@Override
	public void insere(Compra compra) {
		vetCompra.add(compra);
	}

	@Override
	public String remove(String cpf, Calendar data) {

		for (int i = 0; i < vetCompra.size(); i++) {
			if (vetCompra.get(i).getCliente().getCpf().equals(cpf) && vetCompra.get(i).getData().equals(data)) {
				vetCompra.remove(i);
				i--;
				return "Compra Removida!";
			}

		}
		return "Compra não encontrada!";

	}

	@Override
	public void insercaoDireta() {
		// TODO Auto-generated method stub
//teste
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
