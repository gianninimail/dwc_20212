package dao;

import java.util.List;

import model.Endereco;

public interface EnderecoInDAO {

public boolean inserir(Endereco _endereco);
	
	public boolean deletar(long _id);
	
	public boolean alterar(Endereco _endereco);
	
	public Endereco buscarPeloID(long _id);
	
	public List<Endereco> buscarTodos();
}
