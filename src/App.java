import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	static Scanner scan = new Scanner(System.in);
    static final String CAMINHO = "../arquivos/";
    static String arquivoEscolhido = "";

	public static void main(String[] args) throws IOException {

		CadCompra compra = new CadCompra();

		int opcao;

		do {

			System.out.printf(
                ((arquivoEscolhido.equals("")) ? "" : String.format("Arquivo escolhido: %s\n\n", arquivoEscolhido))
                + "1 - Carregar um Arquivo na lista de compras\n"
                + "2 - Ordenar Arquivos Pelo CPF(Insercao Direta)\n"
                + "3 - Criar Arquivo ordenado\n"
                + "4 - Tamanho da lista\n"
                + "5 - Imprimir lista\n"
                + "0 - Sair\n\n"
                + "Escolha: "
            );

			opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    carregarArquivoLista(compra);
                    break;
                case 2:
                    ordenarArquivoTXT(compra);
                    break;
                case 3:
                    criarArquivoOrdenadoTXT(compra);
                    break;
                case 4:
                    imprimirLista(compra);
                    break;

			}
		} while (opcao != 0);

	}

	private static void imprimirLista(CadCompra compra) {

		compra.toStringLista();
		System.out.println();

	}

	private static void carregarArquivoLista(CadCompra compra) throws FileNotFoundException {

		// MUDAR PARA DIRET�RIO DA PESSOA QUE VAI USAR PARA APRESENTAR NO DIA!
		File diretorio = new File(CAMINHO);
		File[] files = diretorio.listFiles();
		String aux = "Selecione um arquivo: " + "\n";
		String nomeDoArquivo = null;

		for (int i = 0; i < files.length; i++) {
			aux += i + " - " + files[i].getName() + "\n";
		}
		System.out.println(aux);

        System.out.printf("Escolha: ");
		int opcao = scan.nextInt();
		for (int i = 0; i <= opcao - 1; i++) {
			nomeDoArquivo = files[i].getName();
		}

		// LER ARQUIVO SELECIONADO INSERINDO ELES NA LISTA
		LerArquivo ler = new LerArquivo();

		long start, end;
		start = System.currentTimeMillis();

		ler.iniciarArquivo(CAMINHO + nomeDoArquivo, compra);
		end = System.currentTimeMillis();
        arquivoEscolhido = files[opcao].getName();
		System.out.println("tempo: " + (end - start) + " ms");
	}

	private static void ordenarArquivoTXT(CadCompra compra) throws FileNotFoundException {
        if (arquivoEscolhido.equals("")) {
            System.out.printf("\nVoce precisa escolher um arquivo primeiro!\n\n");
            return;
        }

		compra.shellSort();
		System.out.println();
		System.out.printf("%s\n", compra);
	}

	private static void criarArquivoOrdenadoTXT(CadCompra compra) {
        if (arquivoEscolhido.equals("")) {
            System.out.printf("\nVoce precisa escolher um arquivo primeiro!\n\n");
            return;
        }

        System.out.printf("%s\n", compra);
	}
}
