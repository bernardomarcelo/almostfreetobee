package controle.servlet.avaliacao;

import modelo.dao.avaliacao.AvaliacaoDAO;
import modelo.dao.avaliacao.AvaliacaoDAOImpl;
import modelo.entidade.avaliacao.Avaliacao;
import modelo.entidade.depoimento.Depoimento;
import modelo.entidade.usuario.Usuario;
import modelo.entidade.estabelecimento.Estabelecimento;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet(urlPatterns = { "/avaliacao/cadastrar", "/avaliacao/novo","/avaliacao/exibir-avaliacao"})
//@WebServlet("/avaliacao/*")
public class AvaliacaoServlet extends HttpServlet {

	// private static final long serialVersionUID = 1L;
	private AvaliacaoDAO dao;

	public void init() {
		dao = new AvaliacaoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String action = request.getServletPath();
		if (action == null)
			action = "/";

		try {
			switch (action) {

			case "/avaliacao/cadastrar":
				cadastrarAvaliacao(request, response);
				break;

			case "/avaliacao/novo":
				TelacadastroAvaliacao(request,response);
				break;
				
			case "/editar":
				editarAvaliacao(request, response);
				break;

			case "/excluir":
				excluirAvaliacao(request, response);
				break;

			case "/avaliacao/exibir-avaliacao":
				exibirAvaliacao(request, response);
				break;

			case "avaliacao/listar-":
				listarAvaliacoes(request, response);
				break;

			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("/erro.jsp");
				dispatcher.forward(request, response);

				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	private void TelacadastroAvaliacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String estabelecimentoId = request.getParameter("estabelecimentoId");
		    if (estabelecimentoId != null && !estabelecimentoId.isEmpty()) {
		        request.setAttribute("estabelecimentoId", estabelecimentoId);
		    }

		    RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroAvaliacao.jsp");
		    dispatcher.forward(request, response);
		
	}

	private void cadastrarAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("usuarioLogado") == null) {
		    response.sendRedirect("login");
		    return;
		}
		
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			
				request.setAttribute("usuario", usuarioLogado);
			
		
		
	    
	    Long estabelecimentoId = Long.parseLong(request.getParameter("estabelecimentoId"));
	    Estabelecimento estabelecimento = new Estabelecimento();
	    estabelecimento.setId(estabelecimentoId);
	    
	    int nota = Integer.parseInt(request.getParameter("nota"));
	    String descricao = request.getParameter("descricao");

	    Avaliacao avaliacao = new Avaliacao(nota, descricao, usuarioLogado, estabelecimento);

	    dao.inserirAvaliacao(avaliacao); 

	    
	    response.sendRedirect(request.getContextPath() + "/estabelecimento/exibir-perfil?id=" + estabelecimento.getId());


	}

	private void editarAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

	}

	private void excluirAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

	}

	private void listarAvaliacoes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Avaliacao> avaliacoes = dao.recuperarAvaliacoes();

		request.setAttribute("avaliacoes", avaliacoes);

		request.getRequestDispatcher("/listarAvaliacoes.jsp").forward(request, response);

	}

	private void exibirAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String idString = request.getParameter("id");
		Long id = Long.parseLong(idString);

		Avaliacao avaliacao = dao.recuperarAvaliacao(id);

		request.setAttribute("avaliacao", avaliacao);
		request.getRequestDispatcher("/exibirAvaliacao.jsp").forward(request, response);

	}

}
