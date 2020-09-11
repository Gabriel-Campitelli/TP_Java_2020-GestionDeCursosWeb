package entities;

public class Persona {
	
	int id_persona;
	String dni;
	String nombre;
	String apellido;
	String usuario;
	String contrasenia;
	String email;
	int rol;

	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "\nPersona [id= " + id_persona + " dni=" + dni + ", Nombre=" + nombre + ", Apellido=" + apellido + ", Email=" + email+ ", Usuario=" + usuario+ ", Rol=" + rol+ "]"
				;
	}
}
