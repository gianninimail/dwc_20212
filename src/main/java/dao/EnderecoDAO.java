package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;

public class EnderecoDAO implements EnderecoInDAO {

	private Connection conexao;
	
	public EnderecoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	public boolean inserir(Endereco _endereco) throws SQLException {

		String SQL = "INSERT INTO pessoa (logradouro, pessoa_cpf) "
				+ "VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _endereco.getLogradouro());
		ps.setLong(2, _endereco.getPessoa().getCpf());
		
		return ps.execute();

	}

	@Override
	public Endereco buscarPeloID(long _id) throws SQLException {
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM endereco WHERE id = " + _id;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Endereco endereco = null;
		
		//SE RS CONSEGUIR APONTAR PARA O MEU UNICO REGISTRO FAÇA
		if(rs.next()) {
			
			endereco = new Endereco();
			endereco.setId(rs.getInt(1));
			endereco.setLogradouro(rs.getString(2));;
		}
		
		return endereco;
	}

	@Override
	public List<Endereco> buscarTodos() throws SQLException {

		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM endereco";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			
			Endereco endereco = new Endereco();
			
			endereco = new Endereco();
			endereco.setId(rs.getInt(1));
			endereco.setLogradouro(rs.getString(2));
		
			
			listaEnderecos.add(endereco);
		}
		
		
		//Retorno do Método
		return listaEnderecos;
	}

	@Override
	public boolean alterar(Endereco _objeto) throws SQLException {
		
		String SQL = "UPDATE endereco SET "
				+ "logrodouro = ? "
				+ " WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getLogradouro());
		
		ps.setInt(6, _objeto.getId());
		
		if(ps.executeUpdate() == 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	@Override
	public boolean deletar(long _id) throws SQLException {

		String SQL = "DELETE FROM endereco WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setLong(1, _id);
		
		if(ps.executeUpdate() == 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	public List<Endereco> recuperarEnderecosPorPessoa(Long _cpf) throws SQLException {

		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "*"
				+ " FROM endereco WHERE pessoa_cpf = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setLong(1, _cpf);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			
			Endereco endereco = new Endereco();
			
			endereco = new Endereco();
			endereco.setId(rs.getInt(1));
			endereco.setLogradouro(rs.getString(2));
		
			
			listaEnderecos.add(endereco);
		}
		
		
		//Retorno do Método
		return listaEnderecos;
	}
}
