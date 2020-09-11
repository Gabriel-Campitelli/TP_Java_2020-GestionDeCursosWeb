package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.CursoLogic;
import logic.ComisionLogic;
import entities.Curso;
import entities.Comision;

/**
 * Servlet implementation class ABMComisiones
 */
@WebServlet({ "/editar-comision", "/alta-comision", "/eliminar-comision" })
public class ABMComisiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMComisiones() {
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

		ComisionLogic comL = new ComisionLogic();
		Comision comision = new Comision();
		
		switch (request.getParameter("modo")) {
		
			case "editar-comision":				
				comision.setIdComision(Integer.parseInt(request.getParameter("id_comision")));
				comision.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
				comision.setDiaSemana(request.getParameter("dia"));
				comision.setCupo(Integer.parseInt(request.getParameter("cupo")));
				comision.setHoraInicio(request.getParameter("hora-inicio"));
				comision.setHoraFin(request.getParameter("hora-fin"));

				comL.edit(comision);
				
				break;
				
			case "alta-comision":				
				comision.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
				comision.setDiaSemana(request.getParameter("dia"));
				comision.setCupo(Integer.parseInt(request.getParameter("cupo")));
				comision.setHoraInicio(request.getParameter("hora-inicio"));
				comision.setHoraFin(request.getParameter("hora-fin"));
			
				comL.create(comision);
				
				break;		
				
			case "eliminar-comision":	
				comision.setIdComision(Integer.parseInt(request.getParameter("id_comision")));
				
				comL.delete(comision);
				
				break;	
				
			default:
				break;
		}
		
		response.sendRedirect("admin-home?param=admin-comisiones");
   
	}	

}
