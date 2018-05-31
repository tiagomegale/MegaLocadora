package application;

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
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", CPF=" + CPF + "]";
	}
	
	public Cliente(String nome, String cPF) {
		super();
		this.nome = nome;
		CPF = cPF;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
