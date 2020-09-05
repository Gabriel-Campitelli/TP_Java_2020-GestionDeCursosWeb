package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Curso;
import logic.CursoLogic;

import java.text.SimpleDateFormat;  
import java.text.ParseException;
  

/**
 * Servlet implementation class ABMCursos
 */
@WebServlet({ "/alta-curso", "/editar-curso", "/eliminar-curso" })
public class ABMCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMCursos() {
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
		// TODO Auto-generated method stub
		CursoLogic cL = new CursoLogic();
		Curso curso = new Curso();
		
	    //response.getWriter().append(request.getParameter("modo"));

		
		switch (request.getParameter("modo")) {
			case "editar-curso":
			    curso.setId(Integer.parseInt(request.getParameter("id_curso")));
			    curso.setNombre(request.getParameter("nombre"));
			    curso.setDescripcion(request.getParameter("descripcion"));
			    curso.setUrl(request.getParameter("url-imagen"));	    
			    //parseo la fecha
			    java.sql.Date sqlFechaInicio = java.sql.Date.valueOf( request.getParameter("fecha-inicio") );  
		        curso.setFecha_inicio(sqlFechaInicio);        
			    
		        java.sql.Date sqlFechaFin = java.sql.Date.valueOf( request.getParameter("fecha-fin") );  
		        curso.setFecha_fin(sqlFechaFin);
		        
				cL.edit(curso);
				break;
			case "alta-curso":
				
			    curso.setNombre(request.getParameter("nombre"));
			    curso.setDescripcion(request.getParameter("descripcion"));
			    curso.setUrl(request.getParameter("url-imagen"));	    
			    //parseo la fecha
		        curso.setFecha_inicio(java.sql.Date.valueOf( "2020-02-12"/*request.getParameter("fecha-inicio") */));        
		        curso.setFecha_fin(java.sql.Date.valueOf( "2020-06-11"/*request.getParameter("fecha-fin") */));
				
			    //response.getWriter().append(curso.toString());

				cL.create(curso);
				break;		
			case "eliminar-curso":
			    curso.setId(Integer.parseInt(request.getParameter("id_curso")));
			    //response.getWriter().append(curso.toString());

				cL.delete(curso);
				break;	
			default:
				break;
		}
		//request.setAttribute("modo", "admin-home");
		request.getRequestDispatcher("WEB-INF/ABMCursos.jsp").forward(request, response);
    
	}

}
