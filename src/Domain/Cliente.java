package domain;

import java.time.LocalDate;

public class Cliente {

	String nome;
	String CPF;
	String endereco;
	String telefone;
	char sexo;
	LocalDate dataDeNascimento;
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Cliente(String nome, String CPF, String endereco, String telefone, char sexo, LocalDate dataDeNascimento) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.endereco = endereco;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public String toString() {
		return "\nCliente [nome=" + nome + ", CPF=" + CPF + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", sexo=" + sexo + ", dataDeNascimento=" + dataDeNascimento + "]";
	}

	
}
