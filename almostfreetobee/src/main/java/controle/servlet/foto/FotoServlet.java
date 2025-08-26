package controle.servlet.foto;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.estabelecimento.EstabelecimentoDAOImpl;
import modelo.dao.usuario.UsuarioDAOImpl;

@WebServlet("/foto")
public class FotoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException {

	        String tipo = request.getParameter("tipo");
	        Long id = Long.parseLong(request.getParameter("id"));

	        byte[] foto = null;

	        switch (tipo) {
	            case "usuario":
	                foto = new UsuarioDAOImpl().recuperarFotoUsuario(id);
	                break;

	            case "estabelecimento":
	                foto = new EstabelecimentoDAOImpl().recuperarFotoEstabelecimento(id);
	                break;

	            default:
	                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tipo inválido");
	                return;
	        }

	        if (foto != null && foto.length > 0) {
	            response.setContentType("image/jpeg");
	            response.getOutputStream().write(foto);
	        } else {
	            
	            response.sendRedirect(request.getContextPath() + "/img/default.png");
	        }
	    }
	}
	


