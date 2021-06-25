package Parciales;
import ListasGenericas.copy.ListaGenerica;

public class Parcial {
	public boolean resolver(ArbolBinario<String> arbol, ListaGenerica<String> unaLista) {
		return recorrer(arbol,unaLista,1);
	}
	
	private boolean recorrer(ArbolBinario<String> arbol, ListaGenerica<String> unaLista, int i) {
		boolean cumpleActual = false;
		boolean cumpleIzq = false;
		boolean cumpleDer = false;
		if (i < unaLista.tamanio()) {
			String elem = unaLista.elemento(i);
			if (arbol.getDato() == elem) {
				cumpleActual = true;
				if (arbol.esHoja()) {
					return true;
				}
			}
			if (arbol.tieneHijoIzquierdo()) {
				cumpleIzq = recorrer(arbol.getHijoIzquierdo(),unaLista,++i);
			}
			if (arbol.tieneHijoDerecho()) {
				cumpleDer = recorrer(arbol.getHijoDerecho(),unaLista,++i);
			}			
		}
		return cumpleActual && (cumpleIzq || cumpleDer);
	}
}