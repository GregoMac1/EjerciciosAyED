package TareaGrafos;

import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaGenerica;

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
}
