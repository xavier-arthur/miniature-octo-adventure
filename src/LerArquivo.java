import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LerArquivo {

	//ESSE METODO RECEBE O CAMINHO DO ARQUIVO A SER LIDO E UMA LISTA INSTANCIADA
	public void iniciarArquivo(String caminho, CadCompra listas) {
		
		StringBuffer memoria = new StringBuffer();
		

		ManipulaData dataModificada = new ManipulaData();
		
		String[] arq = null;

		try {
			BufferedReader arqEntrada;
			arqEntrada = new BufferedReader(new FileReader(caminho));
			String linha = "";
			memoria.delete(0, memoria.length());

			while ((linha = arqEntrada.readLine()) != null) {
				memoria.append(linha + "\n");
				// COLOCANDO DENTRO DO VETOR O CONTEUDO DE CADA LINHA DO ARQUIVO SEPARANDO POR ";"
				arq = linha.split(";");
				
				//COMPARANDO SE CLIENTE ESPECIAL OU CLIENTE NORMAL
				if (arq.length == 4) {
					
					// CONVERTENDO O "VALOR" DE STRING PARA DOUBLE
					double valorDouble = Double.parseDouble(arq[3]);
					// CRIANDO OBJ CLIENTE COM AS INFORMACOES DO TXT
					Cliente novoCliente = new Cliente(arq[0], arq[1]);
					// CRIANDO OBJ COMPRA
					Compra compra = new Compra(novoCliente, dataModificada.LeDataString(arq[2]), valorDouble);
					//INSERINDO OBJ COMPRA NA LISTA DE COMPRAS
					listas.insere(compra);

				} else  {
					
					double cupomDouble = Double.parseDouble(arq[2]);
					double valorDouble = Double.parseDouble(arq[4]);

					ClienteEspecial novoCliente = new ClienteEspecial(arq[0], arq[1], cupomDouble);
					Compra compraEspecial = new Compra(novoCliente, dataModificada.LeDataString(arq[3]), valorDouble);
					// INSERINDO OBJ COMPRA DO TIPO CLIENTE ESPECIAL NA LISTA
					listas.insere(compraEspecial);

				}
			}
			

			arqEntrada.close();
		} catch (FileNotFoundException erro) {
			System.out.println("\nArquivo no encontrado");
		} catch (Exception e) {
			System.out.println("");
		}

	}
}
