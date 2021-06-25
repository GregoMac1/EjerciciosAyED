package CaminoMinimoGrafos;

import ListasGenericas.copy.ListaEnlazadaGenerica;
import ListasGenericas.copy.ListaGenerica;

public class Resultado<T> {
	private int min;
	private ListaGenerica<T> caminoMin;
	
	public Resultado() {
		min = Integer.MAX_VALUE;
		caminoMin = new ListaEnlazadaGenerica<T>();
	}
	
	public ListaGenerica<T> getCaminoMin() {
		return caminoMin;
	}
	
	public int getMin() {
		return min;
	}
	
	public void setCaminoMin(ListaGenerica<T> caminoMin) {
		this.caminoMin = caminoMin.clonar();
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public void actualizarValor(int min, ListaGenerica<T> caminoMin) {
		this.min = min;
		this.caminoMin = caminoMin.clonar();
	}
}
