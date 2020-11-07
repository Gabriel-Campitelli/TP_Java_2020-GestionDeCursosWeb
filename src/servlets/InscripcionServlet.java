package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Curso;
import logic.ComisionLogic;
import logic.CursoLogic;
import logic.InscripcionLogic;
import entities.Inscripcion;
import entities.Persona;

/**
 * Servlet implementation class Inscripcion
 */
@WebServlet("/inscripcion")
public class InscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscripcionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getParameter("item"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Curso c = new Curso();
		c.setId(Integer.parseInt(request.getParameter("curso.id")));
		c.setDescripcion(request.getParameter("curso.desc"));
		c.setNombre(request.getParameter("curso.nombre"));
		c.setUrl(request.getParameter("curso.url"));
		c.setLikes(Integer.parseInt(request.getParameter("curso.likes")));
		SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			Date fecha_fin = formatter.parse(request.getParameter("curso.fin"));
			Date fecha_ini =  formatter.parse(request.getParameter("curso.inicio"));
			c.setFecha_fin(fecha_fin);
			c.setFecha_inicio(fecha_ini);
		} catch (ParseException e) {			
			request.setAttribute("mensaje","No se ha podido realizar la inscripción");
			request.setAttribute("direccion-volver","home?param=home");
			request.setAttribute("mensaje-volver", "Volver al Home");
	    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
		
		request.setAttribute("curso", c);
		request.setAttribute("pageName", "Mis Cursos");
		InscripcionLogic il = new InscripcionLogic();
		Inscripcion i = new Inscripcion();
		ComisionLogic cl = new ComisionLogic();
		
		Persona usuario = new Persona();
		usuario = (Persona)request.getSession().getAttribute("usuario");
		i.setId_persona(usuario.getId_persona());
		i.setId_comision(Integer.parseInt(request.getParameter("item")));
		try {
			il.addInscripcion(i);
			cl.updateCupo(i.getId_comision());
			
			request.setAttribute("inscripcion","inscripcion");
			request.getRequestDispatcher("home").forward(request, response);
		}
		catch (Exception e1) {
			request.setAttribute("mensaje","No se ha podido realizar la inscripción");
			request.setAttribute("direccion-volver","home?param=home");
			request.setAttribute("mensaje-volver", "Volver al Home");
	    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
		
	}

}
