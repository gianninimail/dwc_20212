package dao;

import java.sql.SQLException;
import java.util.List;

import model.Endereco;

public interface EnderecoInDAO {

	public boolean inserir(Endereco _endereco) throws SQLException;
	
	public boolean deletar(long _id) throws SQLException;
	
	public boolean alterar(Endereco _endereco) throws SQLException;
	
	public Endereco buscarPeloID(long _id) throws SQLException;
	
	public List<Endereco> buscarTodos() throws SQLException;
}
