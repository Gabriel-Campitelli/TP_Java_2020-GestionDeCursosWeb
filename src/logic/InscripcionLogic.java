package logic;

import data.DataInscripcion;
import entities.Inscripcion;

public class InscripcionLogic {
	private DataInscripcion dI = new DataInscripcion();
	
	public void addInscripcion(Inscripcion i) {
		dI.addInscripcion(i);
    }
	
	public void editLike(Inscripcion i,int idCurso) {		
		dI.editLike(i,idCurso);
    }
	
	public void deleteInscripcion(Inscripcion i) {
		dI.deleteInscripcion(i);
    }
	
	public Inscripcion getInscripcionBy_Persona_Curso(int idPersona, int idCurso) {
		return dI.getInscripcionBy_Persona_Curso(idPersona, idCurso);
    }
}
