package MutableObjects;
public class MutableInteger {
	private int dato;
	
	public MutableInteger(int dato) {
		this.dato = dato;
	}
	
	public void setDato(int dato) {
		this.dato = dato;
	}
	
	public int getDato() {
		return dato;
	}	
}
