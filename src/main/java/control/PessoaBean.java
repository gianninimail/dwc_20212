package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import dao.FabricaConexao;
import dao.PessoaDAO;
import model.Pessoa;

@ManagedBean
@ViewScoped
public class PessoaBean {

	private List<Pessoa> pessoas;
    
    @PostConstruct
    public void init() {
    	try {
    		
    		PessoaDAO dao = new PessoaDAO(FabricaConexao.fazerConexao());
            this.pessoas = dao.buscarTodos();
            
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    }

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
}
