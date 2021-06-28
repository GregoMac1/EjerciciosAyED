package p2ej2;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int comision;
	private String email;
	private String direccion;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getComision() {
		return comision;
	}
	public String getEmail() {
		return email;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public String tusDatos() {
		return "Nombre: " + this.getNombre() + ". Apellido: " + this.getApellido() 
				+ ". Comision: " + this.getComision() + ". Email: " + this.getEmail()
				+ ". Direccion: " + this.getDireccion();
	}
}
