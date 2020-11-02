package servlets;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.ComisionLogic;
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
				try {
					comision.setIdComision(Integer.parseInt(request.getParameter("id_comision")));
					comision.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
					comision.setDiaSemana(request.getParameter("dia"));
					comision.setCupo(Integer.parseInt(request.getParameter("cupo")));
					comision.setHoraInicio(request.getParameter("hora-inicio"));
					comision.setHoraFin(request.getParameter("hora-fin"));
				
					if(LocalTime.parse(comision.getHoraInicio()).compareTo(LocalTime.parse(comision.getHoraFin()))<0) {
			    	
			    		comL.edit(comision);
			    		    	
				    }
				    else {
						request.setAttribute("mensaje","El horario de inicio del curso en esa comisión es posterior a su horario de fin.");
						request.setAttribute("direccion-volver","admin-home?param=admin-comisiones");
						request.setAttribute("mensaje-volver", "Volver a editar comisiones");
	
				    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);

				    }
		    	}
				catch (Exception e) {
					
					request.setAttribute("mensaje","No se ha podido editar la comisión, por favor vuelva a intentarlo mas tarde.");
					request.setAttribute("direccion-volver","WEB-INF/ABMComisiones.jsp");
					request.setAttribute("mensaje-volver", "Volver a comisiones");

			    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				}
				
				break;
				
			case "alta-comision":				
				try {
					comision.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
					comision.setDiaSemana(request.getParameter("dia"));
					comision.setCupo(Integer.parseInt(request.getParameter("cupo")));
					comision.setHoraInicio(request.getParameter("hora-inicio"));
					comision.setHoraFin(request.getParameter("hora-fin"));
					
				    if(LocalTime.parse(comision.getHoraInicio()).compareTo(LocalTime.parse(comision.getHoraFin()))<0) {
						comL.create(comision);
				    }
				    else {
						request.setAttribute("mensaje","El horario de inicio del curso en esa comisión es posterior a su horario de fin.");
						request.setAttribute("direccion-volver","admin-home?param=admin-comisiones");
						request.setAttribute("mensaje-volver", "Volver a alta comisiones");
	
				    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				    }
				}
				catch (Exception e){
					
					request.setAttribute("mensaje","No se ha podido dar de alta la comision, por favor vuelva a intentarlo mas tarde.");
					request.setAttribute("direccion-volver","WEB-INF/ABMComisiones.jsp");
					request.setAttribute("mensaje-volver", "Volver a comisiones");

			    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				}
				
				break;		
				
			case "eliminar-comision":	
				try {
					comision.setIdComision(Integer.parseInt(request.getParameter("id_comision")));
					
					comL.delete(comision);
				}
				catch (Exception e){
					
					request.setAttribute("mensaje","No se ha podido eliminar la comision, por favor vuelva a intentarlo mas tarde.");
					request.setAttribute("direccion-volver","WEB-INF/ABMComisiones.jsp");
					request.setAttribute("mensaje-volver", "Volver a comisiones");

			    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
				}
					
				break;	
				
			default:
				break;
		}
		
		response.sendRedirect("admin-home?param=admin-comisiones");
   
	}	

}
