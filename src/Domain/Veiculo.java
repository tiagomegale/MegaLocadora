package domain;

public class Veiculo {
	
	String marca;
	String placa;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", marca=" + marca + "]";
	}
	
	public Veiculo(String placa, String marca) {
		super();
		this.placa = placa;
		this.marca = marca;
	}

	
}
