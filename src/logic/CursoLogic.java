package logic;
import java.util.LinkedList;

import data.DataCurso;
import entities.*;

public class CursoLogic {
	
	private DataCurso dc;
	
	public CursoLogic() {
		dc = new DataCurso();
	}

	public LinkedList<Curso> getAll() throws Exception {
		
		return dc.getAll();
	}

	public LinkedList<Curso> getByIdPersona(int id) throws Exception {
		
		return dc.getByIdPersona(id);
	}
	
	public LinkedList<Curso> getByLikes() throws Exception {
		
		return dc.getByLikes();
	}
	
	public Curso getById(int id) throws Exception {
		// TODO Auto-generated method stub
		
		return dc.getById(id);
	}
	
	public LinkedList<Curso> getByNombre (String nombre) throws Exception {
		
		return dc.getByNombre(nombre);
	}


	public void create(Curso nuevoCurso) throws Exception {
		dc = new DataCurso();
		dc.create(nuevoCurso);
	}

	public void delete(Curso curso) throws Exception {
		
		
		dc.delete(curso);
		
	}


	public void edit(Curso curso) throws Exception{
		dc = new DataCurso();
		dc.edit(curso);
		
	}
	public void countLike(int id_curso, int like) throws Exception {
		
		dc.countLike(id_curso,like);
	}


}