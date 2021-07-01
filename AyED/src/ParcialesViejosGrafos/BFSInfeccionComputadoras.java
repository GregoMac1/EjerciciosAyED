package ParcialesViejosGrafos;

import Grafos.Arista;
import Grafos.Grafo;
import Grafos.Vertice;
import ListasGenericas.ColaGenerica;
import ListasGenericas.ListaEnlazadaGenerica;
import ListasGenericas.ListaGenerica;
import MutableObjects.MutableInteger;

public class BFSInfeccionComputadoras {
	
	public int getMaxTiempo(Grafo<String> grafo, String inicial) {
		MutableInteger tiempo = new MutableInteger(0);
		ListaGenerica<Vertice<String>> vertices = new ListaEnlazadaGenerica<Vertice<String>>();
		boolean[] marca = new boolean[vertices.tamanio() + 1];
		vertices.comenzar();
		while(!vertices.fin()) {
			Vertice<String> actual = vertices.proximo();
			if (actual.dato().equals(inicial))
				getMaxTiempo(grafo, actual, tiempo, marca);
		}
		return tiempo.getDato();
	}
	
	public void getMaxTiempo(Grafo<String> grafo, Vertice<String> inicial, 
			MutableInteger tiempo, boolean[] marca) {
		marca[inicial.getPosicion()] = true;
		ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
		cola.encolar(inicial);
		cola.encolar(null);
		while (!cola.esVacia()) {
			Vertice<String> v = cola.desencolar();
			if (v != null) {
				ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
				ady.comenzar();
				while (!ady.fin()) {
					Arista<String> arista = ady.proximo();
					if (!marca[arista.getVerticeDestino().getPosicion()])
						marca[arista.getVerticeDestino().getPosicion()] = true;
						cola.encolar(arista.getVerticeDestino());
				}
			} else if (!cola.esVacia()){
				tiempo.setDato(tiempo.getDato() + 1);
				cola.encolar(null);
			}
		}
	}
}
