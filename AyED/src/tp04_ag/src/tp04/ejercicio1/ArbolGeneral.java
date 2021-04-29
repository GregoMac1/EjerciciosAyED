package tp04_ag.src.tp04.ejercicio1;

import ListasGenericas.src.tp02.ejercicio2.copy.ColaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaGenerica;

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

	public ListaEnlazadaGenerica<T> preOrden(){
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		lista.agregarFinal(this.getDato());
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		while (!hijos.fin()) {
			ArbolGeneral<T> arbol = hijos.proximo();
			for (int i = 0; i < arbol.preOrden().tamanio(); i++) {
				lista.agregarFinal(arbol.preOrden().elemento(i));
			}
		}
		return lista;
	}
	
	public ListaEnlazadaGenerica<T> inOrden(){ //no estoy seguro de que este bien
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();		
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		ArbolGeneral<T> arbol;
		if (hijos.elemento(0) != null) {
			arbol = hijos.elemento(0);
			for (int i = 0; i < arbol.inOrden().tamanio(); i++) {
				lista.agregarFinal(arbol.inOrden().elemento(i));
			}
		}
		lista.agregarFinal(this.getDato());
		while (!hijos.fin()) {
			arbol = hijos.proximo();
			for (int i = 0; i < arbol.inOrden().tamanio(); i++) {
				lista.agregarFinal(arbol.inOrden().elemento(i));
			}
		}
		return lista;
	}
	
	public ListaEnlazadaGenerica<T> postOrden(){
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		while (!hijos.fin()) {
			ArbolGeneral<T> arbol = hijos.proximo();
			for (int i = 0; i < arbol.postOrden().tamanio(); i++) {
				lista.agregarFinal(arbol.postOrden().elemento(i));
			}
		}
		lista.agregarFinal(this.getDato());
		return lista;
	}
	
	public ListaEnlazadaGenerica<T> porNiveles(){ //hay que ver si esta bien
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<>();
		ArbolGeneral<T> arbol = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			lista.agregarFinal(arbol.getDato());
			if (arbol != null) {				
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				for (int i = 0; i < hijos.tamanio(); i++) {
					cola.encolar(hijos.elemento(i));
				}
			} else if (!cola.esVacia()){
				cola.encolar(null);
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
	
	public Integer altura() {
		// Falta implementar..
		return 0;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

}