package Parciales;
import ListasGenericas.copy.ColaGenerica;
import ListasGenericas.copy.ListaEnlazadaGenerica;
import ListasGenericas.copy.PilaGenerica;

public class ParcialesViejos {
	private ArbolBinario<Integer> arbol;
	
	private int cantDescendientes(ArbolBinario<Integer> arbol) {
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
	
	private int camino(ArbolBinario<Integer> arbol, Integer nivel) {
		int suma = 0;
		suma = (int) (arbol.getDato() * (Math.pow(10.0, nivel)));
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
	
	public ParcialesViejos() {		
	}
	
	public ParcialesViejos(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public void colorearArbol(ArbolBinario<String> arbol, Integer maxColor) {
		ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
		ArbolBinario<String> aux = null;
		cola.encolar(arbol);
		cola.encolar(null);
		int nivel = 0;
		int cantDelNivel = 0;
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (cantDelNivel < maxColor){
					if (nivel % 2 == 1) {
						aux.setDato("negro");
					} else {
						aux.setDato("rojo");
					}
					cantDelNivel++;
				} else {
					aux.setDato("verde");
				}
				if (aux.tieneHijoIzquierdo()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (aux.tieneHijoDerecho()) {
					cola.encolar(aux.getHijoDerecho());
				}				
			}
			else if (!cola.esVacia()) {
				nivel++;
				cantDelNivel = 0;
				cola.encolar(null);
			}
		}		
	}
	
	private int cantNodos = 0;
	private int cantHojas = 0;
	
	public Integer resolverJuli(ArbolBinario<Integer> arbol) {
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> aux = null;
		cola.encolar(arbol);
		cola.encolar(null);
		int cantPositivos = 0;
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (aux.getDato() > 0) {
					cantPositivos++;
				}
				this.cantNodos++;
				if (aux.esHoja()) {
					this.cantHojas++;
				}
				if (aux.tieneHijoIzquierdo()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (aux.tieneHijoDerecho()) {
					cola.encolar(aux.getHijoDerecho());
				}				
			}
			else if (!cola.esVacia()) {
				cola.encolar(null);
			}
		}
		if (cantPositivos % 2 == 0) {
			return this.cantNodos;
		} else {
			return this.cantHojas;
		}
	}
	
	private boolean monodistante = true;
	
	private void recorrer(ArbolBinario<Integer> arbol, int k, int total) {
		if (!arbol.esVacio()) {
			total += arbol.getDato();
			if (arbol.esHoja()) {
				if (total != k) {
					this.monodistante = false;
				}
			}
			if (arbol.tieneHijoIzquierdo()) {
				recorrer(arbol.getHijoIzquierdo(),k,total);
			}
			if (arbol.tieneHijoDerecho()) {
				recorrer(arbol.getHijoDerecho(),k,total);
			}
		}
	}
	
	public boolean esMonodistante(int k) {
		recorrer(this.arbol,k,0);
		return this.monodistante;
	}
	
	private int pares(ArbolBinario<Integer> arbol) {
		int cant = 0;
		if (!arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				cant += pares(arbol.getHijoIzquierdo());
			}
			if (arbol.getDato() % 2 == 0) {
				cant++;
			}
			if (arbol.tieneHijoDerecho()) {
				cant += pares(arbol.getHijoDerecho());
			}
		}
		return cant;
	}
	
	public int cantidadHijosPares() {
		return pares(this.arbol);
	}
	
	private int contar(ArbolBinario<Integer> arbol, int num) {
		int cant = 0;
		if (!arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				cant += contar(arbol.getHijoIzquierdo(),num);
			}
			if (arbol.tieneHijoDerecho()) {
				cant += contar(arbol.getHijoDerecho(),num);
			}
			if (arbol.getDato() == num) {
				cant++;
			}
		}
		return cant;
	}
	
	public int contadorOcurrencias(int num) {
		return contar(this.arbol,num);
	}
	
	private boolean esPrimo(Integer num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public Integer primoPorNiveles() {  //bien
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer> aux = null;
		cola.encolar(this.arbol);
		cola.encolar(null);
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (esPrimo(aux.getDato())){
					return aux.getDato();
				}
				if (aux.tieneHijoIzquierdo()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (aux.tieneHijoDerecho()) {
					cola.encolar(aux.getHijoDerecho());
				}
			}
			else if (!cola.esVacia()) {
				cola.encolar(null);
			}
		}
		return -1;
	}
	
	private Integer datoARetornar;
	private int maxProf = Integer.MIN_VALUE;
	
	public Integer masProfundo() { //bien
		recorridoPostOrden(this.arbol,0);
		if (!this.arbol.esVacio()) {
			return datoARetornar;
		}
		return -1;
	}
	
	private void recorridoPostOrden(ArbolBinario<Integer> arbol, int nivel) {
		if (!arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				recorridoPostOrden(arbol.getHijoIzquierdo(), ++nivel);
			}
			if (arbol.tieneHijoDerecho()) {
				recorridoPostOrden(arbol.getHijoDerecho(), ++nivel);
			}
			if (arbol.esHoja() && (nivel > this.maxProf)) {
				this.maxProf = nivel;
				this.datoARetornar = arbol.getDato();
			}
		}
	}
	
	public Integer minEnOrden() { //bien
		return recorridoInOrden(this.arbol);
	}
	
	private int recorridoInOrden(ArbolBinario<Integer> arbol) {
		int min = 9999;
		if (!arbol.esVacio()) {
			if (arbol.tieneHijoIzquierdo()) {
				min = Math.min(recorridoInOrden(arbol.getHijoIzquierdo()),min);			
			}
			min = Math.min(arbol.getDato(), min);
			if (arbol.tieneHijoDerecho()) {
				min = Math.min(recorridoInOrden(arbol.getHijoDerecho()),min);			
			}
		}
		return min;
	}
	
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
