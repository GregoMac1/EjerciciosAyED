package p3ej5;

import ListasGenericas.src.tp02.ejercicio2.copy.ColaGenerica;
import tp03_ab.tp03.ejercicio1.ArbolBinario;

public class ProfundidadArbolBinario {
	ArbolBinario<Integer> arbol;
	
	public ProfundidadArbolBinario(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}
	
	public int sumaElementosProfundidad(int p) { //bien
		int suma = 0;
		int nivel = 0;
		ArbolBinario<Integer> aux = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(this.getArbol());
		cola.encolar(null);
		while (nivel <= p && !cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				suma = suma + aux.getDato();
				if (aux.tieneHijoIzquierdo()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (aux.tieneHijoDerecho()) {
					cola.encolar(aux.getHijoDerecho());
				}
			}
			else if (!cola.esVacia()) {
				cola.encolar(null);
				nivel++;
			}
		}
		return suma;
	}
}
