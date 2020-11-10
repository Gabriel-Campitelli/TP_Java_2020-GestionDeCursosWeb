package entities;

public class Comision {
	private int idComision;
	private int idCurso;
	private int cupo;
	private String diaSemana;
	private String horaInicio;
	private String horaFin;
	
	public int getIdComision() {
		return idComision;
	}
	public void setIdComision(int idComision) {
		this.idComision = idComision;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getHoraInicio() {
		return horaInicio;
	
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	@Override
	public String toString() {
		return "\nComision [id=" + idComision + ", Curso=" + idCurso + ", hora_inicio=" +horaInicio+" dia_semana= "+ diaSemana +  ", hora_fin=" + horaFin + "]"
				;
	}
}
