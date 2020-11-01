package logic;

import java.util.LinkedList;

import data.DataInscripcion;
import entities.Inscripcion;

public class InscripcionLogic {
	private DataInscripcion dI = new DataInscripcion();
	
	public void addInscripcion(Inscripcion i) throws Exception {
		dI.addInscripcion(i);
    }
	
	public void editLike(Inscripcion i,int idCurso) throws Exception {		
		dI.editLike(i,idCurso);
    }
	
	public void deleteInscripcion(Inscripcion i) {
		dI.deleteInscripcion(i);
    }
	
	public Inscripcion getInscripcionBy_Persona_Curso(int idPersona, int idCurso) throws Exception {
		return dI.getInscripcionBy_Persona_Curso(idPersona, idCurso);
    }

	public LinkedList<Inscripcion> getInscripcionesByPersona(int id_persona) throws Exception  {
		// TODO Auto-generated method stub
		return dI.getInscripcionesByPersona(id_persona);
	}
}
