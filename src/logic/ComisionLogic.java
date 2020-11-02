package logic;

import data.DataComision;
import entities.Comision;

import java.util.LinkedList;



public class ComisionLogic {
	private DataComision dc;
	
	public LinkedList<Comision> getAll() throws Exception {
		dc = new DataComision();
		return dc.getAll();
	}
	
	public void create(Comision nuevaComision) throws Exception {
		dc = new DataComision();
		dc.addComision(nuevaComision);
	}
	
	public void delete(Comision comision) throws Exception {
		dc = new DataComision();
		dc.delete(comision);
	}
	
	
	public void edit(Comision comision) throws Exception {
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
