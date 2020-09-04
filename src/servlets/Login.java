package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
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
		Persona p = new Persona();
		p.setEmail(request.getParameter("user"));
		p.setContrasenia(request.getParameter("password"));
		
		PersonaLogic pL = new PersonaLogic();
		p = pL.getByUser(p);
		
		request.getSession().setAttribute("usuario", p);
		if(p.getRol() == 1) {
			request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("WEB-INF/HomeAdministrador.jsp").forward(request, response);
		}
		
		
		
	}

}
