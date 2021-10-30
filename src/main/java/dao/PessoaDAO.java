package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDAO implements PessoaInDAO {
	
	private Connection conexao;

	public PessoaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public boolean inserir(Pessoa _pessoa) throws SQLException {

		String SQL = "INSERT INTO pessoas (cpf, nome, email) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setLong(1, _pessoa.getCpf());
		ps.setString(2, _pessoa.getNome());
		ps.setString(4, _pessoa.getEmail());
		
		return ps.execute();
	}

	@Override
	public boolean deletar(long _cpf) throws SQLException {

		String SQL = "DELETE FROM pessoa WHERE cpf = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setLong(1, _cpf);
		
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
	public boolean alterar(Pessoa _pessoa) throws SQLException {
		
		String SQL = "UPDATE pessoa SET "
				+ "nome = ?, cel = ?, email = ?, end_padrao = ?"
				+ " WHERE cpf = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _pessoa.getNome());
		ps.setString(3, _pessoa.getEmail());
		//Verificação para ver se EndPadrão foi instanciado
		if (_pessoa.getEndPadrao() != null) {
			ps.setInt(4, _pessoa.getEndPadrao().getId());
		}
		else {
			ps.setNull(4, java.sql.Types.NULL);
		}
		ps.setLong(5, _pessoa.getCpf());
		
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
	public Pessoa buscarPeloID(long _cpf) throws SQLException {
		
		String SQL = "SELECT "
				+ "cpf, nome, email, end_padrao"
				+ " FROM pessoa WHERE cpf = " + _cpf;
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		Pessoa p = null;
		
		//SE RS CONSEGUIR APONTAR PARA O MEU UNICO REGISTRO FAÇA
		if(rs.next()) {
			Long cpf = rs.getLong(1);
			String nome = rs.getString(2);
			String email = rs.getString("email");
			int endPadrao = rs.getInt("end_padrao");
			
			EnderecoDAO daoEnd = new EnderecoDAO(this.conexao);
			
			p = new Pessoa(cpf, nome, email, daoEnd.buscarPeloID(endPadrao), daoEnd.recuperarEnderecosPorPessoa(cpf));
		}
		
		return p;
	}

	@Override
	public List<Pessoa> buscarTodos() throws SQLException {

		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		//Preenchimento da Lista para retorno da Camada Requisitante
		
		String SQL = "SELECT "
				+ "cpf, nome, email, end_padrao"
				+ " FROM pessoas";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		//ENQUANTO RS CONSEGUIR APONTAR PARA O PROXIMO REGISTRO FAÇA
		while(rs.next()) {
			Long cpf = rs.getLong(1);
			String nome = rs.getString(2);
			String email = rs.getString("email");
			int endPadrao = rs.getInt("end_padrao");
			
			//EnderecoDAO daoEnd = new EnderecoDAO(this.conexao);
			
			Pessoa p = new Pessoa(cpf, nome, email, null, null);
			
			listaPessoas.add(p);
		}
		
		
		//Retorno do Método
		return listaPessoas;
	}

}
