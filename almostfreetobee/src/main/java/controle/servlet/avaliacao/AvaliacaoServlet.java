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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/avaliacao/*")
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
			
		String action = request.getPathInfo();
		if (action == null)
			action = "/";

		try {
			switch (action) {

			case "/":
				cadastrarAvaliacao(request, response);
				break;

			case "/editar":
				editarAvaliacao(request, response);
				break;

			case "/excluir":
				excluirAvaliacao(request, response);
				break;

			case "/ver":
				listarAvaliacao(request, response);
				break;

			case "/listar":
				listarAvaliacoes(request, response);
				break;

			default:

				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	private void cadastrarAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long usuarioId = Long.parseLong(request.getParameter("usuarioId"));

		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);

		Long estabelecimentoId = Long.parseLong(request.getParameter("estabelecimentoId"));

		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setId(estabelecimentoId);

		int nota = Integer.parseInt(request.getParameter("nota"));

		String descricao = request.getParameter("descricao");

		dao.inserirAvaliacao(new Avaliacao(nota, descricao, usuario, estabelecimento));
		response.sendRedirect("/teste/avaliacao/listar");

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

	private void listarAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String idString = request.getParameter("id");
		Long id = Long.parseLong(idString);

		Avaliacao avaliacao = dao.recuperarAvaliacao(id);

		request.setAttribute("avaliacao", avaliacao);
		request.getRequestDispatcher("/mostrarAvaliacao.jsp").forward(request, response);

	}

}
