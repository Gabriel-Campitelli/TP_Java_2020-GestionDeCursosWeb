package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Curso;
import entities.Persona;
import logic.CursoLogic;
import logic.InscripcionLogic;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CursoLogic cl = new CursoLogic();
		LinkedList<Curso> cursos = new LinkedList<Curso>();
		switch (request.getParameter("param")) {
		case "home":
			request.getRequestDispatcher("WEB-INF/Home.jsp").forward(request, response);
			break;
		case "cursos":
			request.setAttribute("pageName", "Cursos");
			cursos = cl.getAll();
			request.setAttribute("cursos", cursos);
			request.getRequestDispatcher("WEB-INF/Cursos.jsp").forward(request, response);
			break;
		case "mis-cursos":
			request.setAttribute("pageName", "Mis Cursos");
			Persona user = (Persona)request.getSession().getAttribute("usuario");
			cursos = cl.getByIdPersona(user.getId_persona());
			request.setAttribute("cursos", cursos);
			request.getRequestDispatcher("WEB-INF/Cursos.jsp").forward(request, response);
			
			break;
		case "cursos-qpr":
			request.setAttribute("pageName", "Cursos que puedo realizar");
			request.getRequestDispatcher("WEB-INF/Cursos.jsp").forward(request, response);
			break;
		default:
			System.out.println("Error: opcion no disponible");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
