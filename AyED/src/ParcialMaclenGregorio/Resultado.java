package ParcialMaclenGregorio;

import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class Resultado {
	private ListaGenerica<String> mejorCamino;
	private int mejorPromedio;
	
	public Resultado() {
		mejorCamino = new ListaEnlazadaGenerica<String>();
		mejorPromedio = 0;
	}
	
	public ListaGenerica<String> getMejorCamino() {
		return mejorCamino;
	}
	public void setMejorCamino(ListaGenerica<String> mejorCamino) {
		this.mejorCamino = mejorCamino.clonar();
	}
	public int getMejorPromedio() {
		return mejorPromedio;
	}
	public void setMejorPromedio(int mejorPromedio) {
		this.mejorPromedio = mejorPromedio;
	}
}
