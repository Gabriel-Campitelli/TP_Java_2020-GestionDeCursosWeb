package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Inscripcion;
import entities.Persona;
import logic.CursoLogic;
import logic.InscripcionLogic;

/**
 * Servlet implementation class Like
 */
@WebServlet("/like")
public class Like extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Like() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		Persona user = (Persona)request.getSession().getAttribute("usuario");
		InscripcionLogic il = new InscripcionLogic();
		Inscripcion i = new Inscripcion();
		
		i = il.getInscripcionBy_Persona_Curso(user.getId_persona(), idCurso);
		
		il.editLike(i,idCurso);
		
		if(i.getLike()==0) {
			i.setLike(1);
		}
		else {
			i.setLike(0);
		}

		
		
		CursoLogic cl = new CursoLogic();
		cl.countLike(idCurso, i.getLike());
		
		request.getRequestDispatcher("/home").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
