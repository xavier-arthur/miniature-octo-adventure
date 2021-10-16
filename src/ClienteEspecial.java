
public class ClienteEspecial extends Cliente {
	
	private double valeCompra;
	
	public ClienteEspecial(String nome, String cpf, double valeCompra) {
		super(nome, cpf);
		this.valeCompra = valeCompra;
	}
	
	public double getValeCompra() {
		return valeCompra;
	}
	public void setValeCompra(double valeCompra) {
		this.valeCompra = valeCompra;
	}

	@Override
	public String toString() {
		return "ClienteEspecial [valeCompra=" + valeCompra + "]";
	}

	
}
