import java.util.Calendar;

public interface Vetor {
    public Compra get(int pos);
    public void insere(Compra compra);
    public String remove(String cpf, Calendar data);
}
