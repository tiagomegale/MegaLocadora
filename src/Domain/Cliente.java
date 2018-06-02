package domain;

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
	
	public Cliente(String CPF, String nome) {
		super();
		this.CPF = CPF;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [CPF=" + CPF + ", nome=" + nome + "]";
	}
	
}
