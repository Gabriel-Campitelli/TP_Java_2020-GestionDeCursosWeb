package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
import logic.PersonaLogic;

/**
 * Servlet implementation class CrearCuenta
 */
@WebServlet("/crear-cuenta")
public class CrearCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CrearCuenta() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/CrearCuenta.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    //response.getWriter().append((String)request.getAttribute("inputEmailError"));

		request.setAttribute("inputEmailError","false");
		
			PersonaLogic pL = new PersonaLogic();
			Persona alumnoBuscar = new Persona();
			alumnoBuscar.setEmail(request.getParameter("email"));
			alumnoBuscar = pL.getByMail(alumnoBuscar);
			
		    //response.getWriter().append(request.getParameter("email"));
			
			//response.getWriter().append(alumnoBuscar.toString());

			
			if(alumnoBuscar.getId_persona() == 0) {
				request.setAttribute("inputEmailError", "false");
	
				Persona alumnoNuevo = new Persona();
				alumnoNuevo.setDni(request.getParameter("dni"));
				alumnoNuevo.setNombre(request.getParameter("nombre"));
				alumnoNuevo.setApellido(request.getParameter("apellido"));
				alumnoNuevo.setContrasenia(request.getParameter("password"));
				alumnoNuevo.setEmail(request.getParameter("email"));
				//los nuevos usuarios siempre van a ser alumnos 
				alumnoNuevo.setRol(1);
				
				pL.addPersona(alumnoNuevo);
				
				request.getRequestDispatcher("index.html").forward(request, response);
			}else {
				request.setAttribute("inputEmailError", "true");
				
				
				request.getRequestDispatcher("WEB-INF/CrearCuenta.jsp").forward(request, response);
			}
		
			
	}

}
