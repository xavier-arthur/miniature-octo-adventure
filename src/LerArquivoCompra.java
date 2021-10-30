import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LerArquivoCompra {
	private Scanner scan;
	
	public LerArquivoCompra(String nome) throws FileNotFoundException{
		try {
			this.scan = new Scanner(new File (nome));			
		}
		catch (FileNotFoundException e ) {
			throw new FileNotFoundException("ARQUIVO NÃO ENCONTRADO!");
		}
	}
	
	public ArrayList<Compra> ler () throws ArrayIndexOutOfBoundsException, NumberFormatException{
		CadCompra comra = new CadCompra();
		String linha;
		
		
		
	}
}
