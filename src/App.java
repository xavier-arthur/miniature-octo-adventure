import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		CadCompra compra = new CadCompra();

		int opcao = 5;

		do {

			System.out.println("1 - Carregar um Arquivo na lista de compras");
			System.out.println("2 - Ordenar Arquivos Pelo CPF(Inserção Direta)");
			System.out.println("3 - Criar Arquivo ordenado");
			System.out.println("4 - Tamanho da lista");
			System.out.println("5 - Imprimir lista");
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
			if (opcao == 5) {
				imprimirLista(compra);
			}
		} while (opcao != 0);

	}

	private static void imprimirLista(CadCompra compra) {

		compra.toStringLista();
		System.out.println();

	}

	private static void carregarArquivoLista(CadCompra compra) throws FileNotFoundException {

		// MUDAR PARA DIRETÓRIO DA PESSOA QUE VAI USAR PARA APRESENTAR NO DIA!
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

		// LER ARQUIVO SELECIONADO INSERINDO ELES NA LISTA
		LerArquivoJuanAndIcaro ler = new LerArquivoJuanAndIcaro();

		long start, end;
		start = System.currentTimeMillis();

		ler.iniciarArquivo("C:\\Users\\juanr\\OneDrive\\Área de Trabalho\\PrimeiraEtapaTRabalho\\Arquivos Ordenação/"
				+ nomeDoArquivo, compra);
		end = System.currentTimeMillis();
		System.out.println("tempo: " + (end - start) + " ms");

	}

	private static void ordenarArquivoTXT(CadCompra compra) throws FileNotFoundException {

		compra.shellSort();
		System.out.println();
		compra.toStringLista();

	}

	private static void criarArquivoOrdenadoTXT(CadCompra compra) {
		// TODO Auto-generated method stub

	}

}
