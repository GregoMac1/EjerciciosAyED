package MutableObjects;
public class MutableBoolean {
	private boolean dato;
	
	public MutableBoolean(boolean dato) {
		this.dato = dato;
	}
	
	public void setDato(boolean dato) {
		this.dato = dato;
	}
	
	public boolean getDato() {
		return dato;
	}	
}
