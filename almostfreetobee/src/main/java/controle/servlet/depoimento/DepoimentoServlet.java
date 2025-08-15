package controle.servlet.depoimento;
import modelo.dao.depoimento.DepoimentoDAO;
import modelo.dao.depoimento.DepoimentoDAOImpl;
import modelo.entidade.avaliacao.Avaliacao;
import modelo.entidade.depoimento.Depoimento;
import modelo.entidade.usuario.Usuario;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/depoimento/*")
public class DepoimentoServlet extends HttpServlet {

	//private static final long serialVersionUID = 1L;
	private DepoimentoDAO dao;

	public void init() {
		dao = new DepoimentoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		if (action == null)
			action = "/";
		try {
			switch (action) {
			

			case "/":
				cadastrarDepoimento(request, response);
				break;

			case "/editar":
				editarDepoimento(request, response);
				break;

			case "/excluir":
				excluirDepoimento(request, response);
				break;
			
			case "/ver" :
				listarDepoimento(request, response);
					break;
					
			case "/listar":
				listarDepoimentos(request, response);
				break;
					
			default:
			
				break;
			}

		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	private void cadastrarDepoimento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		

		//Long usuarioId = (Long) request.getSession().getAttribute("usuarioId");
		
		Long usuarioId = Long.parseLong(request.getParameter("usuarioId")); 
		
		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);
		
		Long avaliacaoId = Long.parseLong(request.getParameter("avaliacaoId"));
		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId(avaliacaoId);
		
		String conteudo = request.getParameter("conteudo");
		
		LocalDateTime data =  LocalDateTime.now();
		
		dao.inserirDepoimento(new Depoimento(usuario, conteudo, avaliacao, data));
		response.sendRedirect("/teste/depoimento/listar");

	}

	private void editarDepoimento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{

	}

	private void excluirDepoimento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{

	}

	private void listarDepoimentos(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		
		List <Depoimento> depoimentos = dao.recuperarDepoimentos();
		
		request.setAttribute("depoimentos", depoimentos);
		
		request.getRequestDispatcher("/listarDepoimentos.jsp").forward(request,response);
		
	}
		
	private void listarDepoimento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
						System.out.println("entrou no metodo");

		String idString = request.getParameter("id");
	    Long id = Long.parseLong(idString);

	    Depoimento  depoimento = dao.recuperarDepoimento(id);


	    request.setAttribute("depoimento", depoimento);
	    request.getRequestDispatcher("/listaDepoimentos.jsp").forward(request, response);
	}

}

