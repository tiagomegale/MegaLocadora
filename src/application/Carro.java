package application;

public class Carro {
	
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
		return "Carro [marca=" + marca + ", placa=" + placa + "]";
	}
	
	public Carro(String marca, String placa) {
		super();
		this.marca = marca;
		this.placa = placa;
	}
	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}