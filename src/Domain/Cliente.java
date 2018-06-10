package domain;

import java.time.LocalDate;

public class Cliente {

	String nome;
	String CPF;
	String endereco;
	String telefone;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	char sexo;
	LocalDate dataDeNascimento;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		this.nome = nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataDeNascimento() {
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Cliente(String nome, String CPF, String endereco, String telefone, char sexo, LocalDate dataDeNascimento) {
		super();
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		this.nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Cliente(String nome, String CPF) {
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		super();
		this.nome = nome;
		this.CPF = CPF;
	}

	@Override
	public String toString() {
		return "\nCliente [nome=" + nome + ", CPF=" + CPF + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", sexo=" + sexo + ", dataDeNascimento=" + dataDeNascimento + "]";
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	}

	
}
