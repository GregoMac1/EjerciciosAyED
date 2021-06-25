package ListasGenericas.copy;

public class PilaGenerica<T> {
	private ListaGenerica<T> pila;
	
	public PilaGenerica() {
		pila = new ListaEnlazadaGenerica<T>();
	}
	
	public void apilar(T elem) {
		pila.agregarInicio(elem);
	}
	
	public T desapilar() {
		T aux = pila.elemento(1);
		pila.eliminarEn(1);
		return aux;
	}
	
	public T tope() {
		return pila.elemento(1);
	}
	
	public boolean esVacia() {
		if (pila.esVacia()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
