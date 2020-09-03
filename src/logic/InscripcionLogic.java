package logic;

import data.DataInscripcion;
import entities.Inscripcion;

public class InscripcionLogic {
	private DataInscripcion dI = new DataInscripcion();
	
	public void addInscripcion(Inscripcion i) {
		dI.addInscripcion(i);
    }
	
	public void editLike(Inscripcion i) {		
		dI.editLike(i);
    }
	
	public void deleteInscripcion(Inscripcion i) {
		dI.deleteInscripcion(i);
    }
}
