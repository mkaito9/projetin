package Servlet;

	import java.io.IOException;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import DAO.AbstraticDAO;
	import DAO.UsuarioDAO;
	import MODEL.Usuario;
	
	@WebServlet("/cadastraUsuario")
	public class CadastrarUsuarioServlet extends HttpServlet {
	       private static final long serialVersionUID = 1L;

	       AbstraticDAO<Usuario> dao;

	          public CadastrarUsuarioServlet() {
	              super();
	              dao = new UsuarioDAO();
	          }

	       protected void service(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {

	        Usuario usuario = new Usuario((String) request.getParameter("nome"),
	                 (String) request.getParameter("endereco"));
	        dao.adicionar(usuario);
	        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	        rd.forward(request,response);
	       }
	      }
