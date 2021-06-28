package p3ej3;

import ArbolBinario.ArbolBinario;
import ListasGenericas.ListaEnlazadaGenerica;

public class ContadorArbol {
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesInOrden() { //bien
		ListaEnlazadaGenerica<Integer> pares = new ListaEnlazadaGenerica<Integer>();
		if (!arbol.esVacio()) {				
			if (arbol.tieneHijoIzquierdo()) {
				ContadorArbol contadorHijoIzquierdo = new ContadorArbol(arbol.getHijoIzquierdo());
				ListaEnlazadaGenerica<Integer> listaHijoIzquierdo = contadorHijoIzquierdo.numerosParesInOrden();
				while(!listaHijoIzquierdo.fin()) {
					pares.agregarFinal(listaHijoIzquierdo.proximo());
				}
			}
			if (arbol.getDato() % 2 == 0) {
				pares.agregarFinal(arbol.getDato());
			}
			if (arbol.tieneHijoDerecho()) {
				ContadorArbol contadorHijoDerecho = new ContadorArbol(arbol.getHijoDerecho());
				ListaEnlazadaGenerica<Integer> listaHijoDerecho = contadorHijoDerecho.numerosParesInOrden();
				while(!listaHijoDerecho.fin()) {
					pares.agregarFinal(listaHijoDerecho.proximo());
				}
			}
		}	
		return pares;
	}	
}
