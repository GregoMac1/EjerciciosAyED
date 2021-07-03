package ParcialMaclenGregorio;

public class Datos {
	private String nombre;
	private int profundidad;
	
	public Datos(String nombre, int prof) {
		this.nombre = nombre;
		this.profundidad = prof;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}	
}
