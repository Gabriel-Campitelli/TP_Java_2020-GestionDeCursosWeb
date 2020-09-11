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
	
	
}
