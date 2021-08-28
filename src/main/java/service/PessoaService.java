package service;

import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaService {
	
	List<Pessoa> listaPessoas;
	
	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public PessoaService(int _numInstancias) {
		this.listaPessoas = new ArrayList<Pessoa>();
		
		
		for (int i = 0; i <= _numInstancias; i++) {
			this.listaPessoas.add(new Pessoa(i+1, "teste " + i+1));
		}
	}
	
	public void addPessoa(String _nome) {
		
		this.listaPessoas.add(new Pessoa(this.listaPessoas.size(), _nome));
		
	}

}
