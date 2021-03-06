package logic;

import data.DataComision;
import entities.Comision;

import java.util.LinkedList;



public class ComisionLogic {
	private DataComision dc;
	
	public ComisionLogic() {
		dc = new DataComision();
	}
	public LinkedList<Comision> getAll() throws Exception{
		
		return dc.getAll();
	}
	
	public void create(Comision nuevaComision) throws Exception {
		
		dc.addComision(nuevaComision);
	}
	
	public void delete(Comision comision) throws Exception {
		
		dc.delete(comision);
	}
	
	
	public void edit(Comision comision) throws Exception{
		
		dc.edit(comision);
	}

	public LinkedList<Comision> getComisionesByCurso(int id) throws Exception {
		
		return dc.getComisionesByCurso(id);
	}

	public LinkedList<Comision> getComisionesByIdPersona(int id_persona) throws Exception {
		
		return dc.getComisionesByIdPersona(id_persona);
	}
	public void updateCupo(int id_comision) throws Exception {
		dc.updateCupo(id_comision);
		
	}
	
	
}
