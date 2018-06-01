package Domain;

public class Cliente {

	String nome;
	String CPF;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public Cliente(String nome, String CPF) {
		super();
		this.nome = nome;
		this.CPF = CPF;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", CPF=" + CPF + "]";
	}
	
}
