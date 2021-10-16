
public class Cliente   {

<<<<<<< Updated upstream
    public Cliente() {
    	//teste
	//teste2
    }
}
=======
	  private String nome, cpf;
	   
		public Cliente(String nome, String cpf) {
			this.nome = nome;
			this.cpf = cpf;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		@Override
		public String toString() {
			return "Cliente [nome=" + nome + ", cpf=" + cpf + "]";
		}
		
	  
	}
>>>>>>> Stashed changes
