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
		
		
		try {
			
			CursoLogic cl = new CursoLogic();
			Curso curso ;
			int id = Integer.parseInt(request.getParameter("curso").trim());
			curso = cl.getById(id);
			request.setAttribute("curso", curso);
			LinkedList<Comision> comActuales=  this.getComisionesALasQueMePuedoInscribir(request, response);
			request.setAttribute("comisionesAInscribirme", comActuales);
			
			Persona user = (Persona)request.getSession().getAttribute("usuario");
			LinkedList<Curso> userCursos;
			userCursos = cl.getByIdPersona(user.getId_persona());
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
		catch (Exception e) {			
			request.setAttribute("mensaje","No se han podido obtener los datos del curso!");
			request.setAttribute("direccion-volver","home?param=home");
			request.setAttribute("mensaje-volver", "Volver al Home");
	    	request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
		}
			     	    	     
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public LinkedList<Comision> getComisionesALasQueMePuedoInscribir(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Persona user = (Persona)request.getSession().getAttribute("usuario");
		
		
		CursoLogic cl = new CursoLogic();
		LinkedList<Curso> userCursos = cl.getByIdPersona(user.getId_persona());
		
		Curso cursoActual = (Curso)request.getAttribute("curso");		
		ComisionLogic comLogic = new ComisionLogic();		
		LinkedList<Comision> comActuales= comLogic.getComisionesByCurso(cursoActual.getId());
		LinkedList<Comision> userComisiones = comLogic.getComisionesByIdPersona(user.getId_persona());
		LinkedList<Comision> comisionesFiltradas = new LinkedList<Comision> ();
		
		
		/*
		 	Defino la siguiente para variable, que será cambiada a false si existe algún curso donde las fechas coincidan
		 	con el actual. Esto me permitirá saber si tengo que devolver todas sus comisiones. 
		 	
		 	*/
		Boolean b = true;
		
		request.setAttribute("idCurso", cursoActual.getId());
		
		//Valido los cupos
		int cant = comActuales.size();
		for(int i = 0; i < cant;i++ ) {
			if (comActuales.get(i).getCupo() == 0) {
				comActuales.remove(i);
				cant = cant -1;
				i= i -2;
			}
		}

		for(Curso c : userCursos) {
			if( 
					(cursoActual.getFecha_inicio().after(c.getFecha_inicio()) 
					&& cursoActual.getFecha_inicio().before(c.getFecha_fin()) ) || 
					(cursoActual.getFecha_inicio().before(c.getFecha_inicio()) 
					&& cursoActual.getFecha_fin().after(c.getFecha_inicio()) ) ||
					(cursoActual.getFecha_inicio().equals(c.getFecha_inicio()) 
							&& cursoActual.getFecha_fin().equals(c.getFecha_fin()) )
					) {
							b = false;
							comisionesFiltradas= this.validarDiaHoraComisiones(comActuales, userComisiones, cursoActual);
			}

		}
		if(b) {
			return comActuales;
		}
		else {
			return comisionesFiltradas;
		}
	}
	

	public LinkedList<Comision> validarDiaHoraComisiones (LinkedList<Comision> comActuales, LinkedList<Comision> userComisiones, Curso c) 
			throws ParseException {
		
		LinkedList<Comision> aux = new LinkedList<>();
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
							throw e;
						}
																																			
				}
			}
		}
		return aux;
	}


}
