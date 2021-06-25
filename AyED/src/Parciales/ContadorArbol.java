package Parciales;
import ListasGenericas.copy.ListaEnlazadaGenerica;

public class ContadorArbol {
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosPares(){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		if (!arbol.esVacio()) {
			if (arbol.getDato() % 2 == 0) {
				lista.agregarFinal(arbol.getDato());
			}
			if (arbol.tieneHijoIzquierdo()) {
				ContadorArbol contadorIzq = new ContadorArbol(arbol.getHijoIzquierdo());
				ListaEnlazadaGenerica<Integer> listaIzq = contadorIzq.numerosPares();
				while (!listaIzq.fin()) {
					lista.agregarFinal(listaIzq.proximo());
				}
			}
			if (arbol.tieneHijoDerecho()) {
				ContadorArbol contadorDer = new ContadorArbol(arbol.getHijoDerecho());
				ListaEnlazadaGenerica<Integer> listaDer = contadorDer.numerosPares();
				while (!listaDer.fin()) {
					lista.agregarFinal(listaDer.proximo());
				}
			}
		}
		return lista;
	}
	
}
