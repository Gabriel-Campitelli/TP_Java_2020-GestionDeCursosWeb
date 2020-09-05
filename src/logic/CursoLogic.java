package logic;
import java.util.LinkedList;

import data.DataCurso;
import entities.*;

public class CursoLogic {
	
	private DataCurso dc;

	public LinkedList<Curso> getAll() {
		dc = new DataCurso();
		return dc.getAll();
	}

	public LinkedList<Curso> getByIdPersona(int id) {
		dc = new DataCurso();
		return dc.getByIdPersona(id);
	}
	
	public Curso getById(int id) {
		// TODO Auto-generated method stub
		dc = new DataCurso();
		return dc.getById(id);
	}

	public void create(Curso nuevoCurso) {
		
		dc = new DataCurso();
		dc.create(nuevoCurso);
		
	}

	public void delete(Curso curso) {
		
		dc = new DataCurso();
		dc.delete(curso);
		
	}

	public void edit(Curso curso) {
		dc = new DataCurso();
		dc.edit(curso);
		
	}



}