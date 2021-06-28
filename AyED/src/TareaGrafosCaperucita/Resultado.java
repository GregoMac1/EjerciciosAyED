package TareaGrafosCaperucita;

import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class Resultado {
	private int min;
	private ListaGenerica<String> caminoMin;
	
	public Resultado() {
		min = Integer.MAX_VALUE;
		caminoMin = new ListaEnlazadaGenerica<String>();
	}
	
	public ListaGenerica<String> getCaminoMin() {
		return caminoMin;
	}
	
	public int getMin() {
		return min;
	}
	
	public void setCaminoMin(ListaGenerica<String> caminoMin) {
		this.caminoMin = caminoMin.clonar();
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public void actualizarValor(int min, ListaGenerica<String> caminoMin) {
		this.min = min;
		this.caminoMin = caminoMin.clonar();
	}
}
