package controle.servlet.usuario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import modelo.entidade.usuario.Usuario;

//@WebServlet(urlPatterns = { "/almostfreetobee/cadastrar", "/almostfreetobee", "/sair" })
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {

	// private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;

	public void init() {
		dao = new UsuarioDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {

		case "/novo":
			mostrarTelaCadastro(request, response);
			break;

		case "/cadastrar":
			cadastrarUsuario(request, response);
			break;

		case "/":
			mostrarTelaLogin(request, response);
			break;

		case "/login":
			loginUsuario(request, response);
			break;

		case "/logoutUsuario":
			logoutUsuario(request, response);
			break;

		case "/perfil":
			exibirTelaPerfilUsuario(request, response);
			break;

		case "/homepage":
			mostrarTelaHomepage(request, response);
			break;

		/*
		 * case "/entrar": conectarUsuario(request, response); break;
		 * 
		 * case "/sair": desconectarUsuario(request, response); break;
		 */

		default:
			request.getRequestDispatcher("erro.jsp").forward(request, response);
			break;
		}

	}

	private void mostrarTelaHomepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("loginUsuario.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroUsuario.jsp");
		dispatcher.forward(request, response);

	}

	private void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String apelido = request.getParameter("apelido");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		dao.inserirUsuario(new Usuario(nome, sobrenome, apelido, email, senha));
		response.sendRedirect("login");
	}

	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = dao.buscarPorEmailESenha(email, senha);

		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			response.sendRedirect("homepage");
		} else {
			request.setAttribute("erro", "Email ou senha inválidos.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginUsuario.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void logoutUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect("login");
	}

	protected void exibirTelaPerfilUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			if (usuarioLogado != null) {
				request.setAttribute("usuario", usuarioLogado);
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("exibirPerfilUsuario.jsp");
		dispatcher.forward(request, response);

	}

}
