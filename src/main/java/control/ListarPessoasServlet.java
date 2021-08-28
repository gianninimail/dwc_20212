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
import service.PessoaService;

/**
 * Servlet implementation class ListarPessoasServlet
 */
@WebServlet("/ListarPessoasServlet")
public class ListarPessoasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPessoasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PessoaService serv = new PessoaService(10);
		List<Pessoa> listaPessoas = serv.getListaPessoas();
		
		request.getSession().setAttribute("listaDePessoas", listaPessoas);
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
