import java.util.Calendar;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class Test {

    static CadCompra todas_compras = new CadCompra();
    
    public static void main(String[] args) {
        LerArquivoCompra arquivo;

        arquivo = new LerArquivoCompra("../arquivos/compra500alea.txt");
        arquivo.ler();

        arquivo.getConteudo().forEach(elem -> {
            // System.out.printf("%s | %s\n", elem, elem.length() == 5 ? "NORMAL" : "ESPECIAL");
            for (String s : elem) {
                // System.out.printf("%s ", s);
                if (s.length() == 6) {
                    todas_compras.insere(
                        new Compra(
                            new Cliente(elem[0], elem[1]), 
                            new Calendar().getInstance(),
                            2.12
                        )
                    );
                }
            }
            System.out.printf("\n");
        });

        System.out.printf(todas_compras.toString());
    }
}