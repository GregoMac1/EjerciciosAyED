package ArbolGeneral;

import ListasGenericas.ColaGenerica;
import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public ListaEnlazadaGenerica<T> preOrden(){ //creo que bien
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();  
		preOrdenRecorrido(lista); 
	    return lista;
	}
	
	private void preOrdenRecorrido(ListaEnlazadaGenerica<T> lista){
	    ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
	    lista.agregarFinal(this.getDato());
	    ArbolGeneral<T> arbol;
	    if (!hijos.esVacia()) {	    	
		    hijos.comenzar();
		    while (!hijos.fin()) {
		        arbol = hijos.proximo();
		        arbol.preOrdenRecorrido(lista);
		    }
	    }  
	}
	
	public ListaEnlazadaGenerica<T> inOrden(){ //bien
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();  
		inOrdenRecorrido(lista); 
	    return lista;
	}
	
	private void inOrdenRecorrido(ListaEnlazadaGenerica<T> lista){
	    ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
	    ArbolGeneral<T> arbol;
	    if (!hijos.esVacia()) {
	    	arbol = hijos.elemento(0);
	    	arbol.inOrdenRecorrido(lista);
	    }
	    lista.agregarFinal(this.getDato());
	    hijos.comenzar();
	    while (!hijos.fin()) {
	        arbol = hijos.proximo();
	        arbol.inOrdenRecorrido(lista);
	    }
	}
		
	public ListaEnlazadaGenerica<T> postOrden(){ //bien
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();  
		postOrdenRecorrido(lista); 
	    return lista;
	}
	
	private void postOrdenRecorrido(ListaEnlazadaGenerica<T> lista){
	    ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
	    ArbolGeneral<T> arbol;
	    if (!hijos.esVacia()) {	    	
		    hijos.comenzar();
		    while (!hijos.fin()) {
		        arbol = hijos.proximo();
		        arbol.postOrdenRecorrido(lista);
		    }
	    }
	    lista.agregarFinal(this.getDato());
	}
	
	@SuppressWarnings("unused")
	public ListaEnlazadaGenerica<T> porNiveles(){ //bien
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		if (!this.esVacio()) {
			ArbolGeneral<T> arbol = null;
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
			cola.encolar(this);
			cola.encolar(null);
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				lista.agregarFinal(arbol.getDato());
				if (arbol != null) {				
					ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						ArbolGeneral<T> hijo = hijos.proximo();
						if (!hijo.esVacio()) {
							cola.encolar(hijo);
						}
					}
				} else if (!cola.esVacia()){
					cola.encolar(null);
				}
			}
		}
		return lista;
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public Integer altura() { //bien
		return alturaRecorrido();
	}
	
	private int alturaRecorrido(){
	    ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
	    ArbolGeneral<T> arbol;
	    int max = 0;
	    if (!hijos.esVacia()) {	    	
		    hijos.comenzar();
		    while (!hijos.fin()) {
		        arbol = hijos.proximo();
		        int actual = arbol.alturaRecorrido();
                if (actual > max) {
                	max = actual;
                }
		    }
	    } 
	    return max + 1;
	}	

	public Integer nivel(T dato) { //bien
		int nivel = 0;
		if (!this.esVacio()) {
			ArbolGeneral<T> arbol = null;
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
			cola.encolar(this);
			cola.encolar(null);
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				if (arbol != null) {				
					ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
					hijos.comenzar();
					if (arbol.getDato().equals(dato)) {
						return nivel;
					}
					while (!hijos.fin()) {
						ArbolGeneral<T> hijo = hijos.proximo();
						if (!hijo.esVacio()) {
							cola.encolar(hijo);
						}
					}
				} else if (!cola.esVacia()){
					cola.encolar(null);
					nivel++;
				}
			}
		}
		return -1; //no se encontro
	}

	public Integer ancho() { //bien
		int max = 0;
		if (!this.esVacio()) {
			ArbolGeneral<T> arbol = null;
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
			cola.encolar(this);
			cola.encolar(null);
			int anchoActual;
			while (!cola.esVacia()) {
				arbol = cola.desencolar();
				anchoActual = 0;
				if (arbol != null) {				
					ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						ArbolGeneral<T> hijo = hijos.proximo();
						if (!hijo.esVacio()) {
							cola.encolar(hijo);
						}
					}
					anchoActual++;
				} else if (!cola.esVacia()){
					cola.encolar(null);
					if (anchoActual > max) {
						max = anchoActual;
					}
				}
			}
		}
		return max;
	}

}