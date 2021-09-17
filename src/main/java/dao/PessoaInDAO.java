package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pessoa;

public interface PessoaInDAO {

	public boolean inserir(Pessoa _pessoa) throws SQLException;
	
	public boolean deletar(long _cpf) throws SQLException;
	
	public boolean alterar(Pessoa _pessoa) throws SQLException;
	
	public Pessoa buscarPeloID(long _cpf) throws SQLException;
	
	public List<Pessoa> buscarTodos() throws SQLException;
	
}
