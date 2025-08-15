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


//@WebServlet(urlPatterns = { "/cadastrar", "/entrar", "/sair" })
@WebServlet ("/")
public class UsuarioServlet extends HttpServlet {

    //private static final long serialVersionUID = 1L;
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

            case "/exibirPerfilUsuario":
                exibirPerfilUsuario(request, response);
                break;

            case "/login-usuario":
                loginUsuario(request, response);
                break;

            case "/logoutUsuario":
                logoutUsuario(request, response);
                break;

        /*case "/entrar":
            conectarUsuario(request, response);
            break;

        case "/sair":
            desconectarUsuario(request, response);
            break;*/

            default:
                response.sendRedirect("/erro.jsp");
                break;
        }
    }


    protected void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario usuario = usuarioDAO.buscarPorEmailESenha(email, senha);

        if (usuario != null) {
            HttpSession session = request.getSession();
            System.out.println(session);
            session.setAttribute("usuarioLogado", usuario);
            response.sendRedirect("exibirPerfilUsuario?id=" + usuario.getId());
        } else {
            request.setAttribute("erro", "Email ou senha inválidos.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-usuario.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void logoutUsuario(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

        protected void exibirPerfilUsuario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

            String idParam = request.getParameter("id");
            Long id;
            id = Long.parseLong(idParam);
            HttpSession session = request.getSession();
            Usuario usuario = dao.recuperarUsuario(id);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/exibirPerfilUsuario.jsp").forward(request, response);

        }

    private void mostrarTelaLoginUsuario(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("login-usuario.jsp");
        dispatcher.forward(request, response);

    }

}
