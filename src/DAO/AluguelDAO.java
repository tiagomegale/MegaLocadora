package DAO;

import java.sql.Connection;
import java.sql.Date;
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
		String sql = "select idAluguel, dataDeInicioAluguel, dataDeTerminoAluguel, quantidadeDeDiarias, valorDiaria, taxas, valorTotal, nomeClienteAluguel, cpfClienteAluguel, placaVeiculoAluguel, nomeVeiculoAluguel, kmPre, kmPos from ALUGUEIS order by dataDeInicioAluguel";

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
				Veiculo veiculo = new Veiculo(resultSet.getString("placaVeiculoAluguel"), resultSet.getString("nomeVeiculoAluguel"));
				Cliente cliente = new Cliente(resultSet.getString("nomeClienteAluguel"),resultSet.getString("cpfClienteAluguel"));
				Aluguel aluguel = new Aluguel(resultSet.getInt("idAluguel"),
											  resultSet.getDate("dataDeInicioAluguel").toLocalDate(),
											  resultSet.getDate("dataDeTerminoAluguel").toLocalDate(),
											  resultSet.getInt("quantidadeDeDiarias"),
											  resultSet.getDouble("valorDiaria"),
											  resultSet.getDouble("taxas"),
											  resultSet.getDouble("valorTotal"),
											  veiculo,
											  cliente,
											  resultSet.getInt("kmPre"),
											  resultSet.getInt("kmPos"));
				listaDeAlugueis.add(aluguel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaDeAlugueis;

	}	
	
	public boolean alugaVeiculo(Aluguel aluguel) {
		String sql = "insert into ALUGUEIS (dataDeInicioAluguel, dataDeTerminoAluguel, quantidadeDeDiarias, valorDiaria, taxas, valorTotal, nomeClienteAluguel, cpfClienteAluguel, placaVeiculoAluguel, nomeVeiculoAluguel, kmPre, kmPos) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

		try {
			this.statement = conexao.prepareStatement(sql);
			this.statement.setDate(1, Date.valueOf(aluguel.getDataDeInicioAluguel()));
			this.statement.setDate(2, Date.valueOf(aluguel.getDataDeTerminoAluguel()));
			this.statement.setInt(3,  aluguel.getQuantidadeDeDiarias());
			this.statement.setDouble(4, aluguel.getValorDiaria());
			this.statement.setDouble(5, aluguel.getTaxas());
			this.statement.setDouble(6, aluguel.getValorTotal());
			this.statement.setString(7, aluguel.getCliente().getNome());
			this.statement.setString(8, aluguel.getCliente().getCPF());
			this.statement.setString(9, aluguel.getVeiculo().getPlacaVeiculo());
			this.statement.setString(10, aluguel.getVeiculo().getNomeVeiculo());
			this.statement.setInt(11, aluguel.getKmPre());
			this.statement.setInt(12, aluguel.getKmPos());
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
