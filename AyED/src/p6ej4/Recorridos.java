package p6ej4;

import ListasGenericas.src.tp02.ejercicio2.copy.ColaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class Recorridos<T> {
	
	public ListaEnlazadaGenerica<Vertice<T>> dfs (Grafo<T> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<Vertice<T>> lista = new ListaEnlazadaGenerica<Vertice<T>>();
		for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i])
				this.dfs(i, grafo, lista, marca);
		}
		return lista;
	}
	
	private void dfs (int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> lista, boolean[] marca){
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		lista.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()){
			int j = ady.proximo().getVerticeDestino().getPosicion();
			if (!marca[j])
				this.dfs(j, grafo, lista, marca);
		}
	}
	
	public ListaEnlazadaGenerica<Vertice<T>> bfs (Grafo<T> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<Vertice<T>> lista = new ListaEnlazadaGenerica<Vertice<T>>();
		for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i])
				this.bfs(i, grafo, lista, marca);
		}
		return lista;
	}
	
	private void bfs (int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> lista, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		cola.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while (!cola.esVacia()) {
			Vertice<T> v = cola.desencolar();
			lista.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.getVerticeDestino().getPosicion();
				if (!marca[j]) {
					Vertice<T> w = arista.getVerticeDestino();
					marca[j] = true;
					cola.encolar(w);
				}
			}
		}
	}
}
