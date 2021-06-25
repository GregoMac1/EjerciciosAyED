package ArbolBinario;

import ListasGenericas.copy.ColaGenerica;
import ListasGenericas.copy.ListaEnlazadaGenerica;
import ListasGenericas.copy.ListaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho;

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		boolean lleno = true;
		cola.encolar(this);
		int cantNodos = 0;		
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacia() && lleno) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.println(arbol.getDato());
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
					cantNodos++;
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
					cantNodos++;
				}
			}
			else if (!cola.esVacia()) {
				if (cantNodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cantNodos = 0;
					System.out.println();
				}		
				else {
					lleno = false;
				}
			}
		}
		return lleno;
	}

	 boolean esCompleto() {
		return false;
	}

	
	// imprime el árbol en preorden  
	public void printPreorden() {
		if (this != null && !this.esVacio()) {
			System.out.println(this.getDato());		
			if (this.tieneHijoIzquierdo()) {
				this.getHijoIzquierdo().printPreorden();
			}
			if (this.tieneHijoDerecho()) {
				this.getHijoDerecho().printPreorden();
			}
		}
	}
	
	public void printEnOrden() {	
		if (this != null && !this.esVacio()) {
			if (this.tieneHijoIzquierdo()) {
				this.getHijoIzquierdo().printEnOrden();
			}
			System.out.println(this.getDato());
			if (this.tieneHijoDerecho()) {
				this.getHijoDerecho().printEnOrden();
			}
		}
	}

	// imprime el �rbol en postorden
	public void printPostorden() {		
		if (this != null && !this.esVacio()) {
			if (this.tieneHijoIzquierdo()) {
				this.getHijoIzquierdo().printPreorden();
			}
			if (this.tieneHijoDerecho()) {
				this.getHijoDerecho().printPreorden();
			}
			System.out.println(this.getDato());
		}
	}	


	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.println(arbol.getDato());
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			}
			else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}

	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();

		return l;
	}

	
	
	
	public int contarHojas() { //bien
		int cantHojas = 0;
		if (!this.esVacio()) {			
			if (!this.tieneHijoDerecho() && !this.tieneHijoIzquierdo()) {
				cantHojas++;
			}
			else {
				if (this.tieneHijoIzquierdo()) {
					cantHojas += this.getHijoIzquierdo().contarHojas();
				}
				if (this.tieneHijoDerecho()) {
					cantHojas += this.getHijoDerecho().contarHojas();
				}
			}			
		}
		return cantHojas;
	}
	
	public ArbolBinario<T> espejo(){ //bien
		ArbolBinario<T> arbolEspejo = new ArbolBinario<>(this.getDato());
		if (this.tieneHijoIzquierdo()) {
			arbolEspejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		}
		if (this.tieneHijoDerecho()) {
			arbolEspejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		}		
		return arbolEspejo;
	}
	
	public void entreNiveles(int inf, int sup) { //bien
		int nivel = 0;
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (nivel <= sup && !cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (nivel>=inf) {
					System.out.println(arbol.getDato());
				}
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			}
			else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
				nivel++;
			}
		}
	}
}