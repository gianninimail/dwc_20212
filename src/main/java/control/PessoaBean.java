package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

import dao.FabricaConexao;
import dao.PessoaDAO;
import model.Pessoa;

@ManagedBean
@ViewScoped
public class PessoaBean {

	private List<Pessoa> pessoas;
	private ListDataModel<Pessoa> listaJSF;
	
	//Back-Bean - Classe de apoio para o Managed Bean / Manipulação de Dados
	private Pessoa pessoa;
	
	public PessoaBean() {
		this.pessoa = new Pessoa();
	}
    
    @PostConstruct
    public void init() {
    	carregarDados();
    }

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public ListDataModel<Pessoa> getListaJSF() {
		return listaJSF;
	}

	public void setListaJSF(ListDataModel<Pessoa> listaJSF) {
		this.listaJSF = listaJSF;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void carregarDados() {
		try {
			
			PessoaDAO dao = new PessoaDAO(FabricaConexao.fazerConexao());
	        this.pessoas = dao.buscarTodos();
			this.listaJSF = new ListDataModel<Pessoa>(this.pessoas);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	public void PrepararCadastrar() {
		this.pessoa = new Pessoa();
	}
	
	public void Cadastrar() {
		try {
			
			PessoaDAO dao = new PessoaDAO(FabricaConexao.fazerConexao());
			
			dao.inserir(this.pessoa);
			
			carregarDados();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararEditar() {
		this.pessoa = listaJSF.getRowData();
	}
	
	public void Editar() {
		try {
			
			PessoaDAO dao = new PessoaDAO(FabricaConexao.fazerConexao());
			if(dao.alterar(this.pessoa)) {
				carregarDados();
				//JSFMessage.adicionarMensagemDeSucesso("Pessoa atualizada com sucesso!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
