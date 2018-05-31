package application;

public class Aluguel {
	
	String dataDeInicio;
	String dataDeTermino;
	Carro carro;
	Cliente cliente;
	
	public String getDataDeInicio() {
		return dataDeInicio;
	}
	public void setDataDeInicio(String dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}
	public String getDataDeTermino() {
		return dataDeTermino;
	}
	public void setDataDeTermino(String dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Aluguel [dataDeInicio=" + dataDeInicio + ", dataDeTermino=" + dataDeTermino + ", carro=" + carro
				+ ", cliente=" + cliente + "]";
	}
	
	public Aluguel(String dataDeInicio, String dataDeTermino, Carro carro, Cliente cliente) {
		super();
		this.dataDeInicio = dataDeInicio;
		this.dataDeTermino = dataDeTermino;
		this.carro = carro;
		this.cliente = cliente;
	}
	
	public Aluguel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
