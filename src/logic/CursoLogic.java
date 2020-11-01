package logic;
import java.util.LinkedList;

import data.DataCurso;
import entities.*;

public class CursoLogic {
	
	private DataCurso dc;

	public LinkedList<Curso> getAll() throws Exception {
		dc = new DataCurso();
		return dc.getAll();
	}

	public LinkedList<Curso> getByIdPersona(int id) throws Exception {
		dc = new DataCurso();
		return dc.getByIdPersona(id);
	}
	
	public LinkedList<Curso> getByLikes() throws Exception {
		dc = new DataCurso();
		return dc.getByLikes();
	}
	
	public Curso getById(int id) throws Exception {
		// TODO Auto-generated method stub
		dc = new DataCurso();
		return dc.getById(id);
	}
	
	public LinkedList<Curso> getByNombre (String nombre) throws Exception {
		dc = new DataCurso();
		return dc.getByNombre(nombre);
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
	public void countLike(int id_curso, int like) throws Exception {
		dc = new DataCurso();
		dc.countLike(id_curso,like);
	}


}