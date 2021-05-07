import ListasGenericas.src.tp02.ejercicio2.copy.ColaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.PilaGenerica;

public class ParcialesViejos {
	private ArbolBinario<Integer> arbol;
	
	public int cantDescendientes(ArbolBinario<Integer> arbol) {
		int cant = 0;
		if (arbol.esHoja()) {
			cant++;
		}
		else {
			if (arbol.tieneHijoIzquierdo()) {
				cant += cantDescendientes(arbol.getHijoIzquierdo());
			}
			if (arbol.tieneHijoDerecho()) {
				cant += cantDescendientes(arbol.getHijoDerecho());
			}
		}
		return cant;
	}
	
	public ListaEnlazadaGenerica<Integer> resolver(ArbolBinario<Integer> arbol) { //bien
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		if (arbol.esHoja()) {
			lista.agregarFinal(arbol.getDato());
		}
		else if (arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho()) {
			if (cantDescendientes(arbol.getHijoIzquierdo()) == cantDescendientes(arbol.getHijoDerecho())) {
				lista.agregarFinal(arbol.getDato());
			}
		}
		if (arbol.tieneHijoIzquierdo()) {
			ListaEnlazadaGenerica<Integer> listaIzq = resolver(arbol.getHijoIzquierdo());
			while (!listaIzq.fin()) {
				lista.agregarFinal(listaIzq.proximo());
			}
		}
		if (arbol.tieneHijoDerecho()) {
			ListaEnlazadaGenerica<Integer> listaDer = resolver(arbol.getHijoDerecho());
			while (!listaDer.fin()) {
				lista.agregarFinal(listaDer.proximo());
			}
		}
		return lista;
	}
	
	public int camino(ArbolBinario<Integer> arbol, int nivel) {
		int suma = 0;
		double nivelDouble = nivel;
		suma = (int) (arbol.getDato() * (Math.pow(10.0, nivelDouble)));
		if (arbol.getDato() % 2 == 0) {			
			if (arbol.tieneHijoIzquierdo()) {
				suma += camino(arbol.getHijoIzquierdo(),nivel+1);
			}
		} else {
			if (arbol.tieneHijoDerecho()) {
				suma += camino(arbol.getHijoDerecho(),nivel+1);
			}
		}
		return suma;
	}
	
	public int resolver_dos(ArbolBinario<Integer> arbol) { //bien
		int suma = camino(arbol,0);
		return suma;
	}
	
	/*public ParcialesViejos(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}*/
	
	public Integer buscarPrimerElementoUltimoNivel() { //bien
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		PilaGenerica<Integer> pila = new PilaGenerica<Integer>();
		ArbolBinario<Integer> aux = null;
		cola.encolar(this.arbol);
		cola.encolar(null);
		boolean primerElemento = true;
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (primerElemento) {
					pila.apilar(aux.getDato());
					primerElemento = false;
				}
				if (aux.tieneHijoIzquierdo()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (aux.tieneHijoDerecho()) {
					cola.encolar(aux.getHijoDerecho());
				}
			}
			else if (!cola.esVacia()) {
				primerElemento = true;
				cola.encolar(null);
			}
		}
		return pila.tope();
	}
	
	public ListaEnlazadaGenerica<Integer> codigoZigZag(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<String> codigo){ //bien
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ArbolBinario<Integer> aux;
		String subString;
		while (!codigo.fin()) {
			aux = arbol;
			subString = codigo.proximo();
			for (int i = 0; i < subString.length(); i++) {
				if (aux.tieneHijoIzquierdo() && subString.charAt(i) == '0') {
					aux = aux.getHijoIzquierdo();
				}
				else if (aux.tieneHijoDerecho() && subString.charAt(i) == '1'){
					aux = aux.getHijoDerecho();
				}				
			}
			lista.agregarFinal(aux.getDato());
		}		
		return lista;
	}
}
