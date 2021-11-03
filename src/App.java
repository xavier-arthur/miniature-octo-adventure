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
		
		long start, end;
		for (File arquivo : new File(CAMINHO).listFiles()) {

			for (int i = 1; i <=3; i++) {
				start = System.currentTimeMillis();
				carregarArquivo(arquivo.getName(), compra);
				ordernarEscrever(compra, i);
				System.out.printf("arquivo: %s\n", arquivo.getName());
				arquivoEscolhido = arquivo.getName();

				end = System.currentTimeMillis();
				System.out.printf("TEMPO TOTAL (%s): %sms\n",
					switch (i) {
						case 1 ->  "shellsort";
						case 2 ->  "quicksort";
						case 3 ->  "insercacao direta";
						default -> "";
					}, (end - start)
				);
			}
		}
	}

	static void ordernarEscrever(CadCompra c, int tipo) {
		if (tipo == 1) {
			System.out.printf("# Tentando ordernar via shellsort\n\n");
			metodoOrdenacao = "shell";
			c.shellSort();
		} else if (tipo == 2) {
			System.out.printf("# Tentando ordernar via quick\n\n");
			metodoOrdenacao = "quick";
			c.quickSort();
		} else if (tipo == 3) {
			System.out.printf("# Tentando ordernar via insercao\n\n");
			metodoOrdenacao = "insercao";
			c.insercaoDireta();
		}
		criarArquivoOrdenadoTXT(c);
	}

	private static long carregarArquivo(String nome, CadCompra compra) throws FileNotFoundException {
		LerArquivo ler = new LerArquivo();
		long start, end;
		start = System.currentTimeMillis();
		ler.iniciarArquivo(CAMINHO + nome, compra);
		end = System.currentTimeMillis();
		return end - start;
	}

	private static void criarArquivoOrdenadoTXT(CadCompra compra) {

        try {
            var writer = new BufferedWriter(new FileWriter(CAMINHO + arquivoEscolhido + String.format("-ordenado_%s.txt", metodoOrdenacao)));
            writer.write(compra.toString());
            writer.close();
        } catch (IOException err) { 
			System.out.printf("%s\n", err.toString());
		} 
	}
}
