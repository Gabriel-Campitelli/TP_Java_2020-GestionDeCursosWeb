package entities;

public class Inscripcion {

	int id_persona;
	int id_comision;
	int like;
	
	
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
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	
	@Override
	public String toString() {
		return "\nInscripcion [id=" + id_persona + ", idComision=" + id_comision + ", Like=" + like + "]"
				;
	}
	
}
