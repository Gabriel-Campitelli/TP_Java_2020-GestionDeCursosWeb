package servlets;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Comision;
import entities.Curso;
import entities.Persona;
import logic.ComisionLogic;
import logic.CursoLogic;

/**
 * Servlet implementation class CursoDetail
 */
@WebServlet("/cursodetail")
public class CursoDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CursoLogic cl = new CursoLogic();
		Curso curso ;
		int id = Integer.parseInt(request.getParameter("curso").trim());
		curso = cl.getById(id);
		request.setAttribute("curso", curso);
		
		LinkedList<Comision> comActuales=  this.getComisionesALasQueMePuedoInscribir(request, response);
		request.setAttribute("comisionesAInscribirme", comActuales);
		
		Persona user = (Persona)request.getSession().getAttribute("usuario");
		LinkedList<Curso> userCursos = cl.getByIdPersona(user.getId_persona());
		 boolean ocultar = false;
	     for(Curso mc: userCursos) {
	    	 if(mc.getId() == id) {
	    	 ocultar = true;
	    	 }
	     };
	     request.setAttribute("ocultar", ocultar);
	     
	     LinkedList<Curso> cursosRecomendados = cl.getByLikes();
	     request.setAttribute("cursosRecomendados", cursosRecomendados);
	     
	     
	     
		request.getRequestDispatcher("WEB-INF/CursoDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public LinkedList<Comision> getComisionesALasQueMePuedoInscribir(HttpServletRequest request, HttpServletResponse response) {
		
		Persona user = (Persona)request.getSession().getAttribute("usuario");
		
		
		CursoLogic cl = new CursoLogic();
		LinkedList<Curso> userCursos = cl.getByIdPersona(user.getId_persona());
		
		Curso cursoActual = (Curso)request.getAttribute("curso");		
		ComisionLogic comLogic = new ComisionLogic();		
		LinkedList<Comision> comActuales= comLogic.getComisionesByCurso(cursoActual.getId());
		LinkedList<Comision> userComisiones = comLogic.getComisionesByIdPersona(user.getId_persona());
		LinkedList<Comision> aux = new LinkedList<>();
		
		request.setAttribute("prueba", comActuales);
		request.setAttribute("idCurso", cursoActual.getId());
		for(Curso c : userCursos) {
			if( 
					(cursoActual.getFecha_inicio().after(c.getFecha_inicio()) 
					&& cursoActual.getFecha_inicio().before(c.getFecha_fin()) ) || 
					(cursoActual.getFecha_inicio().before(c.getFecha_inicio()) 
					&& cursoActual.getFecha_fin().after(c.getFecha_inicio()) ) ||
					(cursoActual.getFecha_inicio().equals(c.getFecha_inicio()) 
							&& cursoActual.getFecha_fin().equals(c.getFecha_fin()) )
					) {
							request.setAttribute("b1", "Pasa el primer if");
							for(Comision com : userComisiones ) {
								if(com.getIdCurso() == c.getId()) {
									
									for( int i=0; i < comActuales.size();i++) {
										
										SimpleDateFormat parser = new SimpleDateFormat("HH:mm:ss");
										

																						
										Date horaInicioComActual;
										Date horaFinComActual;
										Date horaInicioCom;
										Date horaFinCom;
										try {
											horaInicioComActual = parser.parse(comActuales.get(i).getHoraInicio());
											horaFinComActual = parser.parse(comActuales.get(i).getHoraFin());
											horaInicioCom = parser.parse(com.getHoraInicio());
											horaFinCom = parser.parse(com.getHoraFin());
											if( 
													comActuales.get(i).getDiaSemana().equals(com.getDiaSemana()) && (
													(
															horaInicioComActual.after(horaInicioCom) && horaInicioComActual.before(horaFinCom)
															) 
													|| (
															horaInicioComActual.before(horaInicioCom) && horaFinComActual.after(horaInicioCom)
															
															) 
													|| (	
															horaInicioComActual.equals(horaInicioCom)
															
															)
													) 
												) {
														
											}
											else {
												aux.add(comActuales.get(i));
											}
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
										
										
									}
								}
							}
			}		
		}
		return aux;
	}
	

	/* Agregar id_comision a la inscripcion
	 * 
	public void validarFechas() {
		for(micurso : miscursos) {
		if(otrocurso.fini >= micurso.fini && otro.cursofini < otro.cursoffin ||
				otrocurso.fini < micurs.fini && otrocurso.ffin > micurso.fini) {
			
			ME GUARDO MICURSO EN UNA LISTA
				}
			}
		me traigo las comisiones del otrocurso.
		creo un arreglo identico con las comisiones del otro Curso. Asi voy sacando elementos
		for(mc : lista) {
			me traigo las comisiones del mc.
			for (cada comision de mc) {
				for (cada comision del otro curso)
				voy comparando las horas con cada comision como lo hice al principio. si pasa eso saco el elemento de la lista de comisiones
			}}
		Al final de todo devuelvo la lista de comisiones
			
		}
			
		}
	}
	*/


}
