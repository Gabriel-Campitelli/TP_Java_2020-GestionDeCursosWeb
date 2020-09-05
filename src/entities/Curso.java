package entities;

import java.util.Date;

public class Curso {
	private int id;
	private String descripcion;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String url;
	private String nombre;
	
	public int getId() {
		return id;
	}
	public void setId(Integer inte) {
		this.id = inte;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	@Override
	public String toString() {
		return "\nCurso [id=" + id + ", Descripcion=" + descripcion + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + "]"
				;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
