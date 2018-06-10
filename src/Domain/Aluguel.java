package domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluguel {

	int idAluguel;
	LocalDate dataDeInicioAluguel;
	LocalDate dataDeTerminoAluguel;
	int quantidadeDeDiarias;
	double valorDiaria;
	double taxas;
	double valorTotal;
	Veiculo veiculo;
	Cliente cliente;
	int kmPre;
	int kmPos;
	
	public int getIdAluguel() {
		return idAluguel;
	}

	public void setIdAluguel(int idAluguel) {
		this.idAluguel = idAluguel;
	}
	
	public LocalDate getDataDeInicioAluguel() {
		return dataDeInicioAluguel;
	}

	public void setDataDeInicioAluguel(LocalDate dataDeInicioAluguel) {
		this.dataDeInicioAluguel = dataDeInicioAluguel;
	}

	public LocalDate getDataDeTerminoAluguel() {
		return dataDeTerminoAluguel;
	}

	public void setDataDeTerminoAluguel(LocalDate dataDeTerminoAluguel) {
		this.dataDeTerminoAluguel = dataDeTerminoAluguel;
	}

	public int getQuantidadeDeDiarias() {
		return quantidadeDeDiarias;
	}

	public void setQuantidadeDeDiarias(int quantidadeDeDiarias) {
		this.quantidadeDeDiarias = quantidadeDeDiarias;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public double getTaxas() {
		return taxas;
	}

	public void setTaxas(double taxas) {
		this.taxas = taxas;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getKmPre() {
		return kmPre;
	}

	public void setKmPre(int kmPre) {
		this.kmPre = kmPre;
	}

	public int getKmPos() {
		return kmPos;
	}

	public void setKmPos(int kmPos) {
		this.kmPos = kmPos;
	}

	@Override
	public String toString() {
		return "\nAluguel [idAluguel=" + idAluguel + ", dataDeInicioAluguel=" + dataDeInicioAluguel
				+ ", dataDeTerminoAluguel=" + dataDeTerminoAluguel + ", quantidadeDeDiarias=" + quantidadeDeDiarias
				+ ", valorDiaria=" + valorDiaria + ", taxas=" + taxas + ", valorTotal=" + valorTotal + ", veiculo="
				+ veiculo + ", cliente=" + cliente + ", kmPre=" + kmPre + ", kmPos=" + kmPos + "]";
	}

	public Aluguel(LocalDate dataDeTerminoAluguel, double valorDiaria, Veiculo veiculo, Cliente cliente, int kmPre) {
		super();
		this.dataDeTerminoAluguel = dataDeTerminoAluguel;
		this.valorDiaria = valorDiaria;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.kmPre = kmPre;
		
		// Regras de Negócio do Construtor do Aluguel
		if (this.dataDeInicioAluguel == null) {
			this.dataDeInicioAluguel = LocalDate.now();
		}
		this.quantidadeDeDiarias = (int) ChronoUnit.DAYS.between(dataDeInicioAluguel, dataDeTerminoAluguel);
		this.taxas = (valorDiaria * 0.15) * quantidadeDeDiarias;
		this.valorTotal = (valorDiaria + taxas) * quantidadeDeDiarias;
		
	}

	public Aluguel(int idAluguel, LocalDate dataDeInicioAluguel, LocalDate dataDeTerminoAluguel, int quantidadeDeDiarias,
			double valorDiaria, double taxas, double valorTotal, Veiculo veiculo, Cliente cliente, int kmPre,
			int kmPos) {
		super();
		this.idAluguel = idAluguel;
		this.dataDeInicioAluguel = dataDeInicioAluguel;
		this.dataDeTerminoAluguel = dataDeTerminoAluguel;
		this.quantidadeDeDiarias = quantidadeDeDiarias;
		this.valorDiaria = valorDiaria;
		this.taxas = taxas;
		this.valorTotal = valorTotal;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.kmPre = kmPre;
		this.kmPos = kmPos;
	}
	
	
	
	
}
