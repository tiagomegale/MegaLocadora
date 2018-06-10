package domain;

public class Veiculo {
	
	String placaVeiculo;
	String nomeVeiculo;
	String modeloVeiculo;
	String marcaVeiculo;
	int anoDeFabricacao;
	int anoDeVenda;
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getNomeVeiculo() {
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		return nomeVeiculo;
	}
	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}
	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}
	public void setAnoDeFabricacao(int anoDeFabricacao) {
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		this.anoDeFabricacao = anoDeFabricacao;
	}
	public int getAnoDeVenda() {
		return anoDeVenda;
	}
	public void setAnoDeVenda(int anoDeVenda) {
		this.anoDeVenda = anoDeVenda;
	}
	public String getModeloVeiculo() {
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}
	public void setMarcaVeiculo(String marcaVeiculo) {
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
		this.marcaVeiculo = marcaVeiculo;
	}
	
	public Veiculo(String placaVeiculo, String nomeVeiculo) {
		super();
		this.placaVeiculo = placaVeiculo;
		this.nomeVeiculo = nomeVeiculo;
	}
	
	// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	public Veiculo(String placaVeiculo, String nomeVeiculo, String modeloVeiculo, String marcaVeiculo,
			int anoDeFabricacao, int anoDeVenda) {
		super();
		this.placaVeiculo = placaVeiculo;
		this.nomeVeiculo = nomeVeiculo;
		this.modeloVeiculo = modeloVeiculo;
		this.marcaVeiculo = marcaVeiculo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.anoDeVenda = anoDeVenda;
		// Feito por Tiago Megale - LTP3 Manhã / 2018 - 1o Semestre			
	}
	
	@Override
	public String toString() {
		return "\nVeiculo [placaVeiculo=" + placaVeiculo + ", nomeVeiculo=" + nomeVeiculo + ", modeloVeiculo="
				+ modeloVeiculo + ", marcaVeiculo=" + marcaVeiculo + ", anoDeFabricacao=" + anoDeFabricacao
				+ ", anoDeVenda=" + anoDeVenda + "]";
	}
	
}
