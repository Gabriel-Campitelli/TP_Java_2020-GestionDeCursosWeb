package logic;

import java.util.LinkedList;

import data.DataPersona;
import entities.Persona;

public class PersonaLogic {
	private DataPersona dp;

	public PersonaLogic(){
		dp = new DataPersona();
	}
	
	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}
	
	public Persona getByMail(Persona per) throws Exception {
		Persona pAux = new Persona();
		
		per = dp.getByMail(per);
		
		if(per != null ) 
		{
			return per;
		}
		else {
			pAux.setId_persona(0);
			return pAux;
		}
		
	}
	
	public Persona getByUser(Persona per) throws Exception{
		return dp.getByUser(per);
	}
	
	public void addPersona(Persona p) throws Exception{
		dp.addPersona(p);

	}
	
	public Persona editPersona(Persona pOld, Persona p) {
		return dp.editPersona(pOld, p);
	}
	
	public void deletePersona(Persona p) {
		dp.deletePersona(p);
	}
}
