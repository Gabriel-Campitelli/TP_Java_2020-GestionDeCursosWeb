package entities;

public class Inscripcion {

	int id_persona;
	int id_comision;
	boolean like;
	
	
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public int getId_comision() {
		return id_comision;
	}
	public void setId_comision(int id_curso) {
		this.id_comision = id_curso;
	}
	public boolean getLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	
}
