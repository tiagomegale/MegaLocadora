package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionManager;
import domain.Aluguel;
import domain.Cliente;
import domain.Veiculo;

public class AluguelDAO {

	private Connection conexao = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;

	public AluguelDAO() {
		this.conexao = ConnectionManager.getMysqlConnection();
	}

	public AluguelDAO(Connection conexao) {
		this.conexao = conexao;
	}


	private ResultSet listaTodos() {
		String sql = "select DataDeInicio, DataDeTermino, Placa, Marca, CPF, Nome from ALUGUEIS order by DataDeInicio";

		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}


	// Método publico que retorna um Array de Veiculos
	public static ArrayList<Aluguel> obterListaDeAlugueis(){

		ArrayList<Aluguel> listaDeAlugueis = new ArrayList<Aluguel>();
		Connection conexao;

		try {
			conexao = ConnectionManager.getMysqlConnection();
			AluguelDAO aluguelDAO = new AluguelDAO(conexao);
			ResultSet resultSet = aluguelDAO.listaTodos();

			while (resultSet.next()) {
				Veiculo veiculo = new Veiculo(resultSet.getString("Placa"), resultSet.getString("Marca"));
				Cliente cliente = new Cliente(resultSet.getString("CPF"), resultSet.getString("Nome"));
				Aluguel aluguel = new Aluguel(resultSet.getString("DataDeInicio"), resultSet.getString("DataDeTermino"), veiculo, cliente);
				listaDeAlugueis.add(aluguel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeAlugueis;

	}	


	public boolean alugaVeiculo(Aluguel aluguel) {
		String sql = "insert into ALUGUEIS (DataDeInicio, DataDeTermino, Placa, Marca, CPF, Nome) values (? , ? , ? , ? , ? , ? )";

		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setString(1, aluguel.getDataDeInicio());
			this.statement.setString(2, aluguel.getDataDeTermino());
			this.statement.setString(3, aluguel.getVeiculo().getPlaca());
			this.statement.setString(4, aluguel.getVeiculo().getMarca());
			this.statement.setString(5, aluguel.getCliente().getCPF());
			this.statement.setString(6, aluguel.getCliente().getNome());
			this.statement.executeUpdate();
			System.out.println("Insercao de Aluguel ok");
			return true;
		} catch (SQLException e) {
			System.out.println("____ERRO_____Erro ao criar novo Aluguel:____ERRO_____ " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}	

}
