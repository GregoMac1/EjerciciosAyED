package ParcialJuli;

import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class Resultado {
	private ListaGenerica<String> camino;
	
	public Resultado() {
		camino = new ListaEnlazadaGenerica<String>();
	}

	public ListaGenerica<String> getCamino() {
		return camino;
	}

	public void setCamino(ListaGenerica<String> caminoCumple) {
		this.camino = caminoCumple;
	}	
}
