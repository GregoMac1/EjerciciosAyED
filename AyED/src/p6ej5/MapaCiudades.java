package p6ej5;

import ListasGenericas.src.tp02.ejercicio2.copy.ListaEnlazadaGenerica;
import ListasGenericas.src.tp02.ejercicio2.copy.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;

public class MapaCiudades<T> {
	private GrafoImplListAdy<String> grafo;
	
	public MapaCiudades(GrafoImplListAdy<String> grafo) {
		this.grafo = grafo;
	}
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		boolean[] marca = new boolean[this.grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<String> lista = new ListaEnlazadaGenerica<String>();
		for (int i = 0; i < this.grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i])
				this.devolverCamino(i, this.grafo, lista, marca);
		}
		return lista;
	}
	
	private void devolverCamino (int i, Grafo<String> grafo, ListaGenerica<String> lista, boolean[] marca){
		marca[i] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		lista.agregarFinal(v.dato());
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()){
			int j = ady.proximo().getVerticeDestino().getPosicion();
			if (!marca[j])
				this.devolverCamino(j, grafo, lista, marca);
		}
	}
}
