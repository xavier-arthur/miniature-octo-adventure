import java.util.ArrayList;
import java.util.Scanner;

public class App {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		CadCompra compra = new CadCompra();

		int opcao = 5;

		do {
			// Inserir Arquivo na lista
			System.out.println("1 - Carregar Arquivo TXT");
			// ordenar arquivos nas lista
			System.out.println("2 - Ordenar Arquivos Pelo CPF(Inserção Direta)");
			// Criar um Arquivo txt com o resultado da ordenação
			System.out.println("3 - Criar Arquivo ordenado");

			System.out.println("4 - Tamanho da lista");

			System.out.println("0 - Sair");

			opcao = scan.nextInt();

			if (opcao == 1) {
				carregarArquivoTXT(compra);
			}
			if (opcao == 2) {
				ordenarArquivoTXT(compra);
			}
			if (opcao == 3) {
				criarArquivoOrdenadoTXT(compra);
			}
		} while (opcao != 0);

	}

	private static void carregarArquivoTXT(CadCompra compra) {
		
	}

	private static void ordenarArquivoTXT(CadCompra compra) {
		// TODO Auto-generated method stub

	}

	private static void criarArquivoOrdenadoTXT(CadCompra compra) {
		// TODO Auto-generated method stub

	}

}
