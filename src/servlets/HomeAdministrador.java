package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.PersonaLogic;
import logic.ComisionLogic;
import logic.CursoLogic;


import entities.Comision;
import entities.Curso;
import entities.Persona;

/**
 * Servlet implementation class HomeAdministrador
 */
@WebServlet("/admin-home")
public class HomeAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CursoLogic curL = new CursoLogic();
		ComisionLogic comL = new ComisionLogic();
		PersonaLogic pL = new PersonaLogic();
		
	
		switch (request.getParameter("param")) {
		case "admin-home":
			request.getRequestDispatcher("WEB-INF/HomeAdministrador.jsp").forward(request, response);
			break;
		case "admin-cursos":			
			request.setAttribute("pageName", "Cursos");
			LinkedList<Curso> cursos = curL.getAll();
			request.setAttribute("cursos", cursos);
			request.getRequestDispatcher("WEB-INF/ABMCursos.jsp").forward(request, response);
			break;
			
		case "admin-comisiones":
			request.setAttribute("pageName", "Comisiones");
			LinkedList<Comision> comisiones = comL.getAll();
			request.setAttribute("comisiones", comisiones);
			request.getRequestDispatcher("WEB-INF/ABMComisiones.jsp").forward(request, response);
			break;

		case "admin-clientes":
			request.setAttribute("pageName", "Clientes");
			LinkedList<Persona> clientes = pL.getAll();
			request.setAttribute("clientes", clientes);
			request.getRequestDispatcher("WEB-INF/ABMClientes.jsp").forward(request, response);
			break;
		default:
			System.out.println(request.getParameter("param"));
			System.out.println("Error: opcion no disponible");
			break;
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/HomeAdministrador.jsp").forward(request, response);

		doGet(request, response);
	}

}
