package domain;

import java.time.LocalDate;

public class Veiculo {
	
	String placaVeiculo;
	String nomeVeiculo;
	String modeloVeiculo;
	String marcaVeiculo;
	LocalDate anoDeFabricacao;
	LocalDate anoDeVenda;
	
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getNomeVeiculo() {
		return nomeVeiculo;
	}
	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}
	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}
	public LocalDate getAnoDeFabricacao() {
		return anoDeFabricacao;
	}
	public void setAnoDeFabricacao(LocalDate anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}
	public LocalDate getAnoDeVenda() {
		return anoDeVenda;
	}
	public void setAnoDeVenda(LocalDate anoDeVenda) {
		this.anoDeVenda = anoDeVenda;
	}
	
	public Veiculo(String placaVeiculo, String nomeVeiculo, String modeloVeiculo, String marcaVeiculo,
			LocalDate anoDeFabricacao, LocalDate anoDeVenda) {
		super();
		this.placaVeiculo = placaVeiculo;
		this.nomeVeiculo = nomeVeiculo;
		this.modeloVeiculo = modeloVeiculo;
		this.marcaVeiculo = marcaVeiculo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.anoDeVenda = anoDeVenda;
	}
	
	public Veiculo(String placaVeiculo, String nomeVeiculo) {
		super();
		this.placaVeiculo = placaVeiculo;
		this.nomeVeiculo = nomeVeiculo;
	}
	
	@Override
	public String toString() {
		return "\nVeiculo [placaVeiculo=" + placaVeiculo + ", nomeVeiculo=" + nomeVeiculo + ", modeloVeiculo="
				+ modeloVeiculo + ", marcaVeiculo=" + marcaVeiculo + ", anoDeFabricacao=" + anoDeFabricacao
				+ ", anoDeVenda=" + anoDeVenda + "]";
	}
	
}
