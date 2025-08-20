package controle.servlet.estabelecimento;
import java.sql.Time;

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
import modelo.entidade.avaliacao.Avaliacao;
import modelo.entidade.endereco.Endereco;
import modelo.entidade.estabelecimento.Estabelecimento;
import modelo.enumeracao.estabelecimento.TipoEstabelecimento;
@WebServlet(urlPatterns = { "/estabelecimento/exibir-perfil", "/estabelecimento/novo", "/estabelecimento/cadastrar", "/estabelecimento/listar" })
//@WebServlet("/estabelecimento/*")
public class EstabelecimentoServlet extends HttpServlet {
	
	//private static final long serialVersionUID = 1L;
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
				
			case "/estabelecimento/cadastrar":
				inserirEstabelecimento(request, response);
				break;
				
			case "/estabelecimento/novo":
			TelaInserirEstabelecimento(request, response);
				break;
			
			case "/estabelecimento/exibir-perfil":
                exibirPerfil(request, response);
                break;
                
			case "/pesquisar-estabelecimento":
				pesquisarEstabelecimento(request, response);
				break;
			
			case "/estabelecimento/listar":
				listarEstabelecimentos(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
				dispatcher.forward(request, response);
				break;
			}

		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
	
	
	private void TelaInserirEstabelecimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroEstabelecimento.jsp");
		dispatcher.forward(request, response);
	}

	private void pesquisarEstabelecimento(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void listarEstabelecimentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Estabelecimento> estabelecimentos = daoEstabelecimento.recuperarEstabelecimentos();

		request.setAttribute("estabelecimentos", estabelecimentos);

		request.getRequestDispatcher("/listaEstabelecimentos.jsp").forward(request, response);
		
	}

	private void inserirEstabelecimento(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		String nome = request.getParameter("nome");
		String tipoString = request.getParameter("tipo");
		TipoEstabelecimento tipo = TipoEstabelecimento.valueOf(tipoString.toUpperCase());
		
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		
		Endereco endereco = new Endereco(estado, cidade, bairro, cep, logradouro);
		
		String cnpj = request.getParameter("cnpj");
		
		String aberturaStr = request.getParameter("abertura"); 
		String fechamentoStr = request.getParameter("fechamento");

		Time horarioAbertura = Time.valueOf(aberturaStr + ":00"); 
		Time horarioFechamento = Time.valueOf(fechamentoStr + ":00");	
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

		daoEndereco.inserirEndereco(endereco);
		Long idEndereco = endereco.getId();

		Estabelecimento estabelecimento = new Estabelecimento(nome, tipo, endereco, cnpj, email, telefone, horarioAbertura, horarioFechamento);
		daoEstabelecimento.inserirEstabelecimento(estabelecimento, idEndereco);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/PaginaVerificacao.jsp");
		dispatcher.forward(request, response);
	}

	private void exibirPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	   
		String idString = request.getParameter("id");
	    Long id = Long.parseLong(idString);

	    List<Estabelecimento> estabelecimento = daoEstabelecimento.recuperarEstabelecimentoUnico(id);


	    request.setAttribute("estabelecimento", estabelecimento);
	    request.getRequestDispatcher("exibirPerfilEstabelecimento.jsp").forward(request, response);
	}
}