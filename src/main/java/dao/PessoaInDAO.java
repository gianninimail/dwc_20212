package dao;

import java.util.List;

import model.Pessoa;

public interface PessoaInDAO {

	public boolean inserir(Pessoa _pessoa);
	
	public boolean deletar(long _cpf);
	
	public boolean alterar(Pessoa _pessoa);
	
	public Pessoa buscarPeloID(long _cpf);
	
	public List<Pessoa> buscarTodos();
	
}
