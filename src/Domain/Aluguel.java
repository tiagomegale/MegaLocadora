package Domain;

public class Aluguel {
	
	String dataDeInicio;
	String dataDeTermino;
	Veiculo veiculo;
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
	
	@Override
	public String toString() {
		return "Aluguel [dataDeInicio=" + dataDeInicio + ", dataDeTermino=" + dataDeTermino + ", Veiculo=" + veiculo
				+ ", cliente=" + cliente + "]";
	}
	
	public Aluguel(String dataDeInicio, String dataDeTermino, Veiculo veiculo, Cliente cliente) {
		super();
		this.dataDeInicio = dataDeInicio;
		this.dataDeTermino = dataDeTermino;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	
	public Aluguel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
