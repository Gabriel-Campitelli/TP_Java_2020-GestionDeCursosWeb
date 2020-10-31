package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Comision;
import entities.Curso;
import entities.Inscripcion;
import entities.Persona;
import logic.ComisionLogic;
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
	
		if(request.getAttribute("inscripcion") == "inscripcion") {
			
			this.mostrarMisCursos(request, response, cl);
			request.getRequestDispatcher("WEB-INF/Cursos.jsp").forward(request, response);
		}
		else {
		
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
				this.mostrarMisCursos(request, response, cl);
				
				//response.getWriter().append(listaLikes.toString()).append(userCursos.toString()).append(p.toString()).append(request.getAttribute("insc").toString());
				request.getRequestDispatcher("WEB-INF/Cursos.jsp").forward(request, response);
				
				break;
			default:
				System.out.println("Error: opcion no disponible");
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public LinkedList<Integer> likesSortedByCursos(HttpServletRequest request, HttpServletResponse response,LinkedList<Curso> cursos) throws IOException, ServletException  {
		
	
		
		Persona user = (Persona) request.getSession().getAttribute("usuario");
		
		InscripcionLogic il = new InscripcionLogic();
		LinkedList<Inscripcion> insc = new LinkedList<Inscripcion>();
		
		//Código para generar una lista con los likes que puso el usuario en cada curso.
		//El orden en que se agregan a la lista se corresponde con el orden en que se obtienen los cursos del usuario.
		
		LinkedList<Integer> listaLikes = new LinkedList<>();
		
		try	{
			
			insc = il.getInscripcionesByPersona(user.getId_persona());
			request.setAttribute("insc", insc);
			
			ComisionLogic comLogic = new ComisionLogic();
			LinkedList<Comision> userComisiones = comLogic.getComisionesByIdPersona(user.getId_persona());
			request.setAttribute("com", userComisiones);
			
			for(Curso c: cursos) {		
				for(Comision uc : userComisiones) {
					if(c.getId() == uc.getIdCurso()) {
						for(Inscripcion i : insc) {
							if(i.getId_comision() == uc.getIdComision()) {
								if(i.getLike()==1) {
									listaLikes.add(1);
									request.setAttribute("prueba",1);
								}
								else {
									listaLikes.add(0);
								}							
							}						
						}
					}
				}
			}
		}
		catch (Exception e){
			
			request.setAttribute("mensaje","No se han podido obtener los cursos del usuario, por favor vuelva a loguearse!");
			request.setAttribute("direccion-volver","index.html");
			request.setAttribute("mensaje-volver", "Volver al Login");

	    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);

		}
		  return listaLikes;
		
		
	}
	
	public void mostrarMisCursos(HttpServletRequest request, HttpServletResponse response,CursoLogic cl) throws IOException, ServletException {
		request.setAttribute("pageName", "Mis Cursos");
		LinkedList<Curso> userCursos = new LinkedList<>();
		
		Persona p =(Persona)request.getSession().getAttribute("usuario");
		
		userCursos = cl.getByIdPersona(p.getId_persona());
		
		request.setAttribute("cursos", userCursos);
		
		LinkedList<Integer> listaLikes = this.likesSortedByCursos(request, response, userCursos);
		request.setAttribute("likes", listaLikes);
	}

}

