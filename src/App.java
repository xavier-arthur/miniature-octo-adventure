import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		CadCompra compra = new CadCompra();

		int opcao = 5;

		do {
			System.out.println("1 - Carregar um Arquivo na lista de compras");
			System.out.println("2 - Ordenar Arquivos Pelo CPF(Inser��o Direta)");
			System.out.println("3 - Criar Arquivo ordenado");
			System.out.println("4 - Tamanho da lista");
			System.out.println("0 - Sair");
			opcao = scan.nextInt();

			if (opcao == 1) {
				carregarArquivoLista(compra);
			}
			if (opcao == 2) {
				ordenarArquivoTXT(compra);
			}
			if (opcao == 3) {
				criarArquivoOrdenadoTXT(compra);
			}
		} while (opcao != 0);

	}

	private static void carregarArquivoLista(CadCompra compra) {
		
		// MUDAR PARA DIRET�RIO DA PESSOA QUE VAI USAR PARA APRESENTAR NO DIA!
		File diretorio = new File("C:\\arquivos");
		File[] files = diretorio.listFiles();
		String aux = "Selecione um arquivo: " + "\n";
		String nomeDoArquivo = null;

		for (int i = 0; i < files.length; i++) {
			aux += i + 1 + " - " + files[i].getName() + "\n";
		}
		System.out.println(aux);

		int opcao = scan.nextInt();
		for (int i = 0; i <= opcao - 1; i++) {
			nomeDoArquivo = files[i].getName();
		}
		System.out.println("Arquivo: " + nomeDoArquivo + "\n");
		
		//LER ARQUIVO SELECIONADO INSERINDO ELES NA  LISTA
		LerArquivoJuanAndIcaro ler = new LerArquivoJuanAndIcaro();
		ler.iniciarArquivo("C:/Users/juanr/OneDrive/�rea de Trabalho/PrimeiraEtapaTRabalho/Arquivos Ordena��o/" + nomeDoArquivo,compra);
		compra.toStringLista();
		System.out.println();
		// PRINTANDO TODA A LISTA!
		for (int i = 0; i < compra.listaSize(); i++) {
			compra.toString();
		}
		
	}

	private static void ordenarArquivoTXT(CadCompra compra) {
		// TODO Auto-generated method stub

	}

	private static void criarArquivoOrdenadoTXT(CadCompra compra) {
		// TODO Auto-generated method stub

	}

}
