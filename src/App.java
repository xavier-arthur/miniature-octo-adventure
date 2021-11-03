import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

	static Scanner scan = new Scanner(System.in);
    static final String CAMINHO = "../arquivos/";
    static String arquivoEscolhido = "";
	static String metodoOrdenacao;

	public static void main(String[] args) throws IOException {

		CadCompra compra = new CadCompra();

		int opcao;

		do {

			System.out.printf(
                ((arquivoEscolhido.equals("")) ? "" : String.format("Arquivo escolhido: %s\n\n", arquivoEscolhido))
                + "1 - Carregar um Arquivo na lista de compras\n"
                + "2 - Ordenar Arquivos Pelo CPF\n"
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
					exibirTamanhoDaLista(compra);
					break;
                case 5:
                    imprimirLista(compra);
                    break;

			}
		} while (opcao != 0);

	}

	private static void exibirTamanhoDaLista(CadCompra compra) {
        if (arquivoEscolhido.equals("")) {
            System.out.printf("\nVoce precisa escolher um arquivo primeiro!\n\n");
            return;
        }

		System.out.printf("O tamanho eh %s itens!\n", compra.listaSize());
	}	

	private static void imprimirLista(CadCompra compra) {
        if (arquivoEscolhido.equals("")) {
            System.out.printf("\nVoce precisa escolher um arquivo primeiro!\n\n");
            return;
        }
		System.out.println(compra.toString());
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

		int escolha;
		long start, end;

		System.out.printf(
			"1. QuickSort\n"
			+ "2. Insercacao direta\n"
			+ "3. ShellSort\n"
			+ "4. Voltar\n\n"
			+ "Escolha o método: "
		);

		if ((escolha = scan.nextInt()) < 4) {
			start = System.currentTimeMillis();

			switch (escolha) {
				case 1:
					metodoOrdenacao = "quicksort";
					compra.quickSort();
					break;
				case 2:
					metodoOrdenacao = "insercao_direta";
					compra.insercaoDireta();
					break;
				case 3:
					metodoOrdenacao = "shellsort";
					compra.shellSort();
					break;
			}

			end = System.currentTimeMillis();
			System.out.printf("Compra ordenada, tempo decorrido: %dms\n", (end - start));
		}
	}

	private static void criarArquivoOrdenadoTXT(CadCompra compra) {
        if (arquivoEscolhido.equals("")) {
            System.out.printf("\nVoce precisa escolher um arquivo primeiro!\n\n");
            return;
        }

        try {
            var writer = new BufferedWriter(new FileWriter(CAMINHO + arquivoEscolhido + String.format("-ordenado_%s.txt", metodoOrdenacao)));
            writer.write(compra.toString());
            writer.close();
        } catch (IOException err) { 
			System.out.printf("%s\n", err.toString());
		} 
	}
}
