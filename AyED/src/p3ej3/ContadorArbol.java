package p3ej3;

import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import tp03_ab.tp03.ejercicio1.ArbolBinario;

public class ContadorArbol {
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private ListaEnlazadaGenerica<Integer> numerosParesInOrden() { //bien
		ListaEnlazadaGenerica<Integer> pares = new ListaEnlazadaGenerica<Integer>();
		if (!arbol.esVacio()) {				
			if (arbol.tieneHijoIzquierdo()) {
				ContadorArbol contadorHijoIzquierdo = new ContadorArbol(arbol.getHijoIzquierdo());
				ListaEnlazadaGenerica<Integer> listaHijoIzquierdo = contadorHijoIzquierdo.numerosParesInOrden();
				for (int i = 0; i < listaHijoIzquierdo.tamanio(); i++) {
					pares.agregarFinal(listaHijoIzquierdo.elemento(i));
				}
			}
			if (arbol.getDato() % 2 == 0) {
				pares.agregarFinal(arbol.getDato());
			}
			if (arbol.tieneHijoDerecho()) {
				ContadorArbol contadorHijoDerecho = new ContadorArbol(arbol.getHijoDerecho());
				ListaEnlazadaGenerica<Integer> listaHijoDerecho = contadorHijoDerecho.numerosParesInOrden();
				for (int i = 0; i < listaHijoDerecho.tamanio(); i++) {
					pares.agregarFinal(listaHijoDerecho.elemento(i));
				}
			}
		}	
		return pares;
	}	
}
