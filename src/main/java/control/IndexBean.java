package control;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean(name = "paginaIndex")
@ViewScoped
public class IndexBean {

	private String valorTexto;
	
	public IndexBean() {
		this.valorTexto = "Teste de InputText 123456";
	}

	public String getValorTexto() {
		return valorTexto;
	}
	
	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}

	
}
