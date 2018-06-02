package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionManager;
import domain.Aluguel;

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

	public ResultSet listaTodos() {
		String sql = "select CPF from ALUGUEIS order by CPF";
		
		try {
			this.statement = this.conexao.prepareStatement(sql);
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
		
	}

	public boolean alugaVeiculo(Aluguel aluguel) {
		String sql = "insert into ALUGUEIS (dataDeInicio, dataDeTermino, placa, marca, cpf, nome) values (? , ? , ? , ? , ? , ? )";
		
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
			System.out.println("____ERRO_____Erro ao criar novo veículo:____ERRO_____ " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}	
	
}
