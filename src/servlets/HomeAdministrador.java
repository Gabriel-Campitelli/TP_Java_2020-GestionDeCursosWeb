package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.ComisionLogic;
import logic.CursoLogic;
import entities.Comision;
import entities.Curso;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CursoLogic curL = new CursoLogic();
		ComisionLogic comL = new ComisionLogic();
	
		switch (request.getParameter("param")) {
		case "admin-home":
			request.getRequestDispatcher("WEB-INF/HomeAdministrador.jsp").forward(request, response);
			break;
			
		case "admin-cursos":			
			request.setAttribute("pageName", "Cursos");
			LinkedList<Curso> cursos;
			try {
				cursos = curL.getAll();
				request.setAttribute("cursos", cursos);
				request.getRequestDispatcher("WEB-INF/ABMCursos.jsp").forward(request, response);
			} 
			catch (Exception e) {
					request.setAttribute("mensaje","No se han podido obtener los cursos!");
					request.setAttribute("direccion-volver","admin-home?param=admin-home");
					request.setAttribute("mensaje-volver", "Volver al Home");
			    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
			}
			break;
			
		case "admin-comisiones":
			try {
				request.setAttribute("pageName", "Comisiones");
				LinkedList<Comision> comisiones = comL.getAll();
				request.setAttribute("comisiones", comisiones);
				request.getRequestDispatcher("WEB-INF/ABMComisiones.jsp").forward(request, response);
				}
			catch(Exception e){
				request.setAttribute("mensaje","No se han podido obtener las comisiones!");
				request.setAttribute("direccion-volver","admin-home?param=admin-home");
				request.setAttribute("mensaje-volver", "Volver al Home");
		    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
			}
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
