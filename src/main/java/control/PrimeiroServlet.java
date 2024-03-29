package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;
import service.PessoaService;

/**
 * Servlet implementation class PrimeiroServlet
 */
@WebServlet("/PrimeiroServlet")
public class PrimeiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimeiroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter saidaHtml = response.getWriter();
		
		saidaHtml.println("<html>");
		saidaHtml.println("<head>");
		saidaHtml.println("<title>Primeiro App testando Impressão via Servlet</title>");
		saidaHtml.println("</head>");
		saidaHtml.println("<h1>Lista de Pessoas:</h1>");
		saidaHtml.println("<table border=1>");
		PessoaService serv = new PessoaService(5);
		for (Pessoa p : serv.getListaPessoas()) {
			saidaHtml.println("<tr>");
			saidaHtml.println("<td>" + p.getCpf() + "</td>");
			saidaHtml.println("<td>" + p.getNome() + "</td>");
			saidaHtml.println("</tr>");
		}
		saidaHtml.println("</table>");
		saidaHtml.println("</body>");
		saidaHtml.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
