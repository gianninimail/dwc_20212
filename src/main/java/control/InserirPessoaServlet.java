package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;

/**
 * Servlet implementation class InserirPessoaServlet
 */
@WebServlet("/InserirPessoaServlet")
public class InserirPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int numPessosa = (int)request.getSession().getAttribute("numPessoas");
		
		//PessoaService serv = new PessoaService(numPessosa);
		String nome = request.getParameter("nome");
		
		@SuppressWarnings("unchecked")
		List<Pessoa> listaPessoas = (List<Pessoa>)request.getSession().getAttribute("listaDePessoas"); 
		listaPessoas.add(new Pessoa(listaPessoas.size()+1, nome, null, null, null));
		
		//request.setAttribute("listaDePessoas", serv.getListaPessoas());
		RequestDispatcher despachante = request.getRequestDispatcher("/listaDePessoas.jsp");
		
		despachante.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
