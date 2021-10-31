import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;

public class LerArquivoCompra {

    private File arquivo;
    private Scanner scan;
    private ArrayList<String[]> conteudo;

    public LerArquivoCompra(String caminho){ 
        try {
            this.arquivo = new File(caminho);
            this.scan = new Scanner(this.arquivo);
        } catch (FileNotFoundException err) {
            this.arquivo = null;
            this.scan = null;
        }
        this.conteudo = null;
    }

    public void ler() {
        var builder = new ArrayList<String[]>();

        while (scan.hasNextLine()) {
            builder.add(scan.nextLine().split(";"));
        }

        this.conteudo = builder;
    }

    public ArrayList<String[]> getConteudo() {
        return this.conteudo;
    }
    
    
}
