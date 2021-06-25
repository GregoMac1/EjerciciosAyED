package ListasGenericas.copy;

public class ColaGenerica<T> {
	private ListaEnlazadaGenerica<T> cola;
	
	public ColaGenerica (){
		cola = new ListaEnlazadaGenerica<T>();
	}
	
	public void encolar(T elem) {
		cola.agregarFinal(elem);
	}
	
	public T desencolar() {
		T aux = cola.elemento(1);
		cola.eliminarEn(1);
		return aux;
	}
	
	public T tope() {
		return cola.elemento(1);
	}
	
	public boolean esVacia() {
		if (cola.esVacia()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
