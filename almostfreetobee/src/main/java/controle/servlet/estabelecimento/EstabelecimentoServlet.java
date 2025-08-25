package controle.servlet.estabelecimento;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.endereco.EnderecoDAO;
import modelo.dao.endereco.EnderecoDAOImpl;
import modelo.dao.estabelecimento.EstabelecimentoDAO;
import modelo.dao.estabelecimento.EstabelecimentoDAOImpl;
import modelo.entidade.endereco.Endereco;
import modelo.entidade.estabelecimento.Estabelecimento;
import modelo.enumeracao.estabelecimento.TipoEstabelecimento;

@WebServlet(urlPatterns = {"/PerfilEstabelecimento", "/pesquisar-estabelecimento", "/realizar-pesquisa", "/homepage"})
public class EstabelecimentoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EstabelecimentoDAO daoEstabelecimento;
	private EnderecoDAO daoEndereco;

	public void init() {
		daoEstabelecimento = new EstabelecimentoDAOImpl();
		daoEndereco = new EnderecoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {
			
			switch (action) {
				
			/*case "/inserir":
				inserirEstabelecimento(request, response);
				break;
			*/	
			
			case "/PerfilEstabelecimento":
                exibirPerfil(request, response);
                break;
            
			case "/pesquisar-estabelecimento":
				mostrarTelaPesquisaEstabelecimento(request, response);
				break;
				
			case "/realizar-pesquisa":
				pesquisarEstabelecimento(request, response);
				break;
				
			case "/homepage":
				exibir4Estabelecimentos(request, response);
				break;
                
			default:
				 request.getRequestDispatcher("erro.jsp").forward(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	private void inserirEstabelecimento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String nome = request.getParameter("nome");
		String tipoString = request.getParameter("tipo");
		TipoEstabelecimento tipo = TipoEstabelecimento.valueOf(tipoString.toUpperCase());
		
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String cepString = request.getParameter("cep");
		int cep = Integer.valueOf(cepString);
		String logradouro = request.getParameter("logradouro");
		
		Endereco endereco = new Endereco(estado, cidade, bairro, cep, logradouro);
		
		String cnpj = request.getParameter("cnpj");
		
		String horarioAbertura = request.getParameter("abertura");
		String horarioFechamento = request.getParameter("fechamento");	
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		daoEndereco.inserirEndereco(endereco);
		Long idEndereco = endereco.getId();

		Estabelecimento estabelecimento = new Estabelecimento(nome, tipo, endereco, cnpj, email, telefone, horarioAbertura);
		daoEstabelecimento.inserirEstabelecimento(estabelecimento, idEndereco);
		response.sendRedirect("listar");
	}

	private void exibirPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	   
		String idString = request.getParameter("id");
	    Long id = Long.parseLong(idString);

	    List<Estabelecimento> estabelecimento = daoEstabelecimento.recuperarEstabelecimentoUnico(id);


	    request.setAttribute("estabelecimento", estabelecimento);
	    request.getRequestDispatcher("/PerfilEstabelecimento.jsp").forward(request, response);
	}
	
	private void pesquisarEstabelecimento(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		
		String nome = request.getParameter("recuperarEstabelecimento");
		List<Estabelecimento> estabelecimentoRecuperados = daoEstabelecimento.pesquisarEstabelecimento(nome);
		
		request.setAttribute("estabelecimentos", estabelecimentoRecuperados);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-estabelecimento.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	private void mostrarTelaPesquisaEstabelecimento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-estabelecimento.jsp");
		dispatcher.forward(request, response);

	}
	
	private void exibir4Estabelecimentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Estabelecimento> estabelecimentos = daoEstabelecimento.recuperarEstabelecimentosPelaAvaliacao();
		
		request.setAttribute("estabelecimentos", estabelecimentos);
		request.getRequestDispatcher("/homepage.jsp").forward(request, response);
	}
	
}