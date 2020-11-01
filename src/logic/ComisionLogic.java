package logic;

import data.DataComision;
import entities.Comision;

import java.util.LinkedList;



public class ComisionLogic {
	private DataComision dc;
	
	public LinkedList<Comision> getAll() {
		dc = new DataComision();
		return dc.getAll();
	}
	
	public void create(Comision nuevaComision) {
		dc = new DataComision();
		dc.addComision(nuevaComision);
	}
	
	public void delete(Comision comision) {
		dc = new DataComision();
		dc.delete(comision);
	}
	
	
	public void edit(Comision comision) {
		dc = new DataComision();
		dc.edit(comision);
	}

	public LinkedList<Comision> getComisionesByCurso(int id) throws Exception {
		dc = new DataComision();
		
		return dc.getComisionesByCurso(id);
	}

	public LinkedList<Comision> getComisionesByIdPersona(int id_persona) throws Exception {
		
		dc = new DataComision();
		
		return dc.getComisionesByIdPersona(id_persona);
	}
	
	
}
