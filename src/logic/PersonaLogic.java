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
	
	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
	}
	
	public Persona getByUser(Persona per){
		return dp.getByUser(per);
	}
	
	public void addPersona(Persona p) {
		dp.addPersona(p);

	}
	
	public Persona editPersona(Persona pOld, Persona p) {
		return dp.editPersona(pOld, p);
	}
	
	public void deletePersona(Persona p) {
		dp.deletePersona(p);
	}
}
