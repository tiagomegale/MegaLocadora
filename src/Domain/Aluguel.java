package domain;

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
		return "\nAluguel [\ndataDeInicio=" + dataDeInicio + ", \ndataDeTermino=" + dataDeTermino + ", " + veiculo
				+ "," + cliente + "]\n =-=-=-=";
	}
	
	public Aluguel(String dataDeInicio, String dataDeTermino, Veiculo veiculo, Cliente cliente) {
		super();
		
		// Passar de String pra data
		// data De Inicio ser sempre hoje
		// if dataDeInicio =! data de hoje dar um throw
		// if dataDeTermino <= hoje dar outro throw
		// if dataDeInicio
		this.dataDeInicio = dataDeInicio;
		this.dataDeTermino = dataDeTermino;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	
	
}
