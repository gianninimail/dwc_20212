package model;

import java.io.Serializable;
import java.util.Objects;

public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String logradouro;
	private Pessoa pessoa;
	
	public Endereco() {
		this.pessoa = new Pessoa();
	}
	
	public Endereco(int id, String logradouro, Pessoa _pessoa) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.pessoa = _pessoa;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + "]";
	}
}
