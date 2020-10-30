package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Curso;
import entities.Persona;
import logic.CursoLogic;
import logic.PersonaLogic;
import java.util.LinkedList;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	switch (request.getParameter("action")) {
		case "ingresar":
			this.ingresar(request,response);
			break;
		case "crear":
			request.setAttribute("inputEmailError","false");
			request.getRequestDispatcher("WEB-INF/CrearCuenta.jsp").forward(request,response);
			break;
		default:
			System.out.println("Error: opcion no disponible");
			break;
		}	
	}
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Persona p = new Persona();
		p.setEmail(request.getParameter("user"));
		p.setContrasenia(request.getParameter("password"));
		
		PersonaLogic pL = new PersonaLogic();
		try {
				p = pL.getByUser(p);
				request.getSession().setAttribute("usuario", p);
				
				if(p.getRol() == 1) {

					request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("WEB-INF/HomeAdministrador.jsp").forward(request, response);
				}
			}
			catch(Exception e) {
				
				request.setAttribute("mensaje","El usuario y/o contraseña ingresados son incorrectos.");
				request.setAttribute("direccion-volver","index.html");
				request.setAttribute("mensaje-volver", "Volver al Login");

		    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				}
	
		
		
	}
}
