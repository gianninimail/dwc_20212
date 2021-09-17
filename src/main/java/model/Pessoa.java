package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long cpf;
	private String nome;
	private String email;
	
	private Endereco endPadrao;
	
	private List<Endereco> enderecos;
	
	public Pessoa() {
		this.endPadrao = new Endereco();
		this.enderecos = new ArrayList<Endereco>();
	}
	
	public Pessoa(long _cpf, String _nome, String _email, Endereco _endPadrao, List<Endereco> _enderecos) {
		super();
		this.cpf = _cpf;
		this.nome = _nome;
		this.email = _email;
		this.endPadrao = _endPadrao;
		this.enderecos = _enderecos;
	}
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public Endereco getEndPadrao() {
		return endPadrao;
	}

	public void setEndPadrao(Endereco endPadrao) {
		this.endPadrao = endPadrao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return cpf == other.cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", email=" + email + "]";
	}
}
